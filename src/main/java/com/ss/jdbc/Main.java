package com.ss.jdbc;


import com.ss.jdbc.enums.JavaSqlTypeEnums;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.sql.*;

/**
 * Main
 *
 * @author shisong
 * @date 2019/6/18
 */

public class Main {

    private static final String PRE = "com.autoyol.giftCardService";
    private static final String MAPPER = "mapper";
    private static final String ENETIY = "enetiy";
    private static final String XML = "xml";
    private static final String IMPORT_DATE = "import java.util.Date;";
    private static final String IMPORT_LIST = "import java.util.List;";
    private static final String IMPORT_BIGDECIMAL = "import java.math.BigDecimal;";
    private static final String IMPORT_BIGINTEGER = "import java.math.BigInteger;";
    private static final String IMPORT_TIME = "import java.sql.Time;";
    private static final String IMPORT_LOMBOK = "import lombok.Data;";
    private static final String IMPORT_MAPPER = "import org.apache.ibatis.annotations.Mapper;";
    private static final String IMPORT_PARAM = "import org.apache.ibatis.annotations.Param;";
    private static final String ANNOTATION_DATA = "@Data";
    private static final String ANNOTATION_MAPPER = "@Mapper";
    private static final String ANNOTATION_PARAM = "@Param";
    private static final String SQL_COLUMN = "select_column";
    private static final String RESULT_MAP = "selectColumnMap";


    public static void main(String[] args) {

        try {
            //1. JDBC连接MYSQL的代码很标准。
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection("jdbc:mysql://10.0.3.200:3306/gift_card_service", "autoDev", "auto2015");

            DatabaseMetaData metaData = conn.getMetaData();
            String catalog = conn.getCatalog(); //catalog 其实也就是数据库名

            //所有表
            /*ResultSet tablesResultSet = metaData.getTables(catalog,null,null,new String[]{"TABLE"});
            while(tablesResultSet.next()){
                String tableName = tablesResultSet.getString("TABLE_NAME");
                *//*if(tableName.equals("bg_refuse_run")||tableName.equals("qrtz_blob_triggers")||tableName.equals("qrtz_calendars")){
                    continue;
                }*//*
                queryTableColumn(metaData,tableName);
            }*/
            String tableName = "gift_card_code";
            queryTableColumn(metaData, tableName, catalog);
            System.out.println("end");
            //主键
            /*ResultSet primaryKeyResultSet = metaData.getPrimaryKeys(catalog,null,tableName);
            while(primaryKeyResultSet.next()){
                String primaryKeyColumnName = primaryKeyResultSet.getString("COLUMN_NAME");
                System.out.println("主键"+primaryKeyColumnName);
            }*/



            /*ResultSet primaryKeyResultSet = metaData.getPrimaryKeys(catalog,"%","");
            while(primaryKeyResultSet.next()){
                String primaryKeyColumnName = primaryKeyResultSet.getString("COLUMN_NAME");
                System.out.println(primaryKeyColumnName);
            }*/
            //2. 下面就是获取表的信息。
        /*    String m_TableName = "constant";
            DatabaseMetaData metaData = conn.getMetaData();
            ResultSet tableRet = metaData.getTables(null, "%",m_TableName,new String[]{"TABLE"});
            *//*其中"%"就是表示*的意思，也就是任意所有的意思。其中m_TableName就是要获取的数据表的名字，如果想获取所有的表的名字，就可以使用"%"来作为参数了。*//*

            //3. 提取表的名字。
            while(tableRet.next()) System.out.println(tableRet.getString("TABLE_NAME"));*/

            /*通过getString("TABLE_NAME")，就可以获取表的名字了。
            从这里可以看出，前面通过getTables的接口的返回，JDBC是将其所有的结果，保存在一个类似table的内存结构中，而其中TABLE_NAME这个名字的字段就是每个表的名字。*/

            //4. 提取表内的字段的名字和类型
            /*String columnName;
            String columnType;
            ResultSet colRet = metaData.getColumns(null,"%", m_TableName,"%");
            while(colRet.next()) {
                columnName = colRet.getString("COLUMN_NAME");
                columnType = colRet.getString("TYPE_NAME");
                int datasize = colRet.getInt("COLUMN_SIZE");
                int digits = colRet.getInt("DECIMAL_DIGITS");
                int nullable = colRet.getInt("NULLABLE");
                System.out.println(columnName+" "+columnType+" "+datasize+" "+digits+" "+ nullable);
            }

            ResultSet primaryKeyResultSet = metaData.getPrimaryKeys(null,"%",m_TableName);
            while(primaryKeyResultSet.next()){
                String primaryKeyColumnName = primaryKeyResultSet.getString("COLUMN_NAME");
                System.out.println(primaryKeyColumnName);
            }*/
            /*JDBC里面通过getColumns的接口，实现对字段的查询。跟getTables一样，"%"表示所有任意的（字段），而m_TableName就是数据表的名字。

            getColumns的返回也是将所有的字段放到一个类似的内存中的表，而COLUMN_NAME就是字段的名字，TYPE_NAME就是数据类型，比如"int","int unsigned"等等，COLUMN_SIZE返回整数，就是字段的长度，比如定义的int(8)的字段，返回就是8，最后NULLABLE，返回1就表示可以是Null,而0就表示Not Null。*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void queryTableColumn(DatabaseMetaData metaData, String tableName, String catalog) throws Exception {
        ResultSet primaryKeyResultSet = metaData.getPrimaryKeys(catalog, null, tableName);
        String primaryKeyColumnName = "";
        while (primaryKeyResultSet.next()) {
            primaryKeyColumnName = primaryKeyResultSet.getString("COLUMN_NAME");
        }

        String camelTableName = CamelUtils.underline2Camel(tableName, false);
        String className = CamelUtils.underline2Camel(tableName);
        ResultSet colRet = metaData.getColumns(null, "%", tableName, "%");
        queryAndWriteVo(colRet, camelTableName, tableName);
        if (StringUtils.isNotBlank(primaryKeyColumnName)) {
            //当主键不为空时，才生成xml和mapper
            queryAndWriteMapper(colRet, camelTableName, className, primaryKeyColumnName);
            queryAndWriteXml(colRet, camelTableName, className, primaryKeyColumnName, tableName);
        } else {
            System.out.println(tableName + "不存在主键");
        }


    }

    private static void queryAndWriteXml(ResultSet colRet, String camelTableName, String className, String primaryKeyColumnName, String tableName) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
                "<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\" >").append("\n");
        sb.append("<mapper namespace=\"").append(PRE).append(".").append(MAPPER).append(".").append(camelTableName + "Mapper").append("\">").append("\n");
        colRet.beforeFirst();
        appendSql(colRet, sb);
        appendResultMap(colRet, sb, camelTableName);
        appendSaveSql(colRet, sb, camelTableName, primaryKeyColumnName, tableName);
        appendSelectOneSql(colRet, sb, camelTableName, primaryKeyColumnName, tableName);
        appendSelelctListSql(colRet, sb, camelTableName, primaryKeyColumnName, tableName);
        appendUpdateSql(colRet, sb, camelTableName, primaryKeyColumnName, tableName);
        appendDeleteSql(colRet, sb, camelTableName, primaryKeyColumnName, tableName);
        sb.append("</mapper>");

        String file = "E://test3/" + XML;
        String fileName = "/" + camelTableName + "Mapper.xml";
        WriteStringToFile(file, fileName, sb.toString());
    }

    private static void appendDeleteSql(ResultSet colRet, StringBuilder sb, String camelTableName, String primaryKeyColumnName, String tableName) throws Exception {
        //删除 逻辑删除 修改is_delete字段
        colRet.beforeFirst();
        String typeName = "";
        while (colRet.next()) {
            String column_name = colRet.getString("COLUMN_NAME");
            if (column_name.equals(primaryKeyColumnName)) {
                typeName = colRet.getString("TYPE_NAME");
            }
        }
        sb.append("\t").append(" <update id=\"").append("delete" + camelTableName + "ById").append("\" parameterType=\"").append("java.lang.").append(JavaSqlTypeEnums.getValue(typeName)).append("\">").append("\n");
        sb.append("\t\t").append("update ").append(tableName).append(" set").append("\n");
        sb.append("\t\t").append("is_delete = 1,").append("\n");
        sb.append("\t\t").append("update_time = NOW()").append("\n");
        sb.append("\t\t").append("where ").append(primaryKeyColumnName).append(" = #{id}").append(" and is_delete = 0").append("\n");
        sb.append("\t").append("</update>").append("\n\n");
    }

    private static void appendUpdateSql(ResultSet colRet, StringBuilder sb, String camelTableName, String primaryKeyColumnName, String tableName) throws Exception {
        //修改字段  <update id="updateByPrimaryKeySelective" parameterType="com.autoyol.carInfo.entity.CarInspectDo">
        colRet.beforeFirst();
        sb.append("\t").append(" <update id=\"").append("update" + camelTableName).append("\" parameterType=\"").append(PRE).append(".").append(ENETIY).append(".").append(camelTableName).append("\">").append("\n");
        sb.append("\t\t").append("update ").append(tableName).append(" set").append("\n");
        StringBuilder saveSqlSb = new StringBuilder();
        while (colRet.next()) {
            String column_name = colRet.getString("COLUMN_NAME");
            if (!(column_name.equals(primaryKeyColumnName) || column_name.equals("update_time"))) {
                saveSqlSb.append("\t\t").append("<if test=\"").append(CamelUtils.underline2Camel(column_name)).append(" != null\">").append("\n");
                saveSqlSb.append("\t\t\t").append(column_name).append(" = ").append("#{").append(CamelUtils.underline2Camel(column_name)).append("}").append(",").append("\n");
                saveSqlSb.append("\t\t").append("</if>").append("\n");
            }
        }
        sb.append(saveSqlSb);
        sb.append("\t\t").append("update_time = NOW()").append("\n");
        sb.append("\t\t").append("where ").append(primaryKeyColumnName).append(" = #{id}").append(" and is_delete = 0").append("\n");
        sb.append("\t").append("</update>").append("\n\n");

    }

    private static void appendSelelctListSql(ResultSet colRet, StringBuilder sb, String camelTableName, String primaryKeyColumnName, String tableName) throws Exception {
        //查询全部
        colRet.beforeFirst();
        sb.append("\t").append("<select id=\"queryList\" resultType=\"").append(PRE).append(".").append(ENETIY).append(".").append(camelTableName).append("\">").append("\n");
        sb.append("\t\t").append("select <include refid=\"").append(SQL_COLUMN).append("\" />").append("\n");
        sb.append("\t\t").append("from ").append(tableName).append("\n");
        sb.append("\t\t").append("where ").append("is_delete = 0").append("\n");
        sb.append("\t").append("</select>").append("\n\n");
    }

    private static void appendSelectOneSql(ResultSet colRet, StringBuilder sb, String camelTableName, String primaryKeyColumnName, String tableName) throws Exception {
        //根据主键查询 "query"+camelTableName+"ById"
        colRet.beforeFirst();
        sb.append("\t").append("<select id=\"").append("query").append(camelTableName).append("ById").append("\" resultType=\"").append(PRE).append(".").append(ENETIY).append(".").append(camelTableName).append("\">").append("\n");
        sb.append("\t\t").append("select <include refid=\"").append(SQL_COLUMN).append("\" />").append("\n");
        sb.append("\t\t").append("from ").append(tableName).append("\n");
        sb.append("\t\t").append("where ").append(primaryKeyColumnName).append(" = #{id}").append(" and is_delete = 0").append("\n");
        sb.append("\t").append("</select>").append("\n\n");

    }

    private static void appendSaveSql(ResultSet colRet, StringBuilder sb, String camelTableName, String primaryKeyColumnName, String tableName) throws Exception {
        //保存sql
        colRet.beforeFirst();
        StringBuilder saveSqlKeySb = new StringBuilder();
        StringBuilder saveSqlValueSb = new StringBuilder();
        sb.append("\t").append("<insert id=\"").append("save").append(camelTableName).append("\" parameterType=\"").append(PRE).append(".").append(ENETIY).append(".").append(camelTableName)
                .append("\" useGeneratedKeys=\"true\" keyProperty=\"").append(CamelUtils.underline2Camel(primaryKeyColumnName)).append("\" keyColumn=\"").append(primaryKeyColumnName).append("\">").append("\n");
        sb.append("\t\t").append("insert into ").append(tableName).append("(").append("\n");
        while (colRet.next()) {
            String column_name = colRet.getString("COLUMN_NAME");
            if (!(column_name.equals(primaryKeyColumnName) || column_name.equals("create_time"))) {
                saveSqlKeySb.append("\t\t\t").append("<if test=\"").append(CamelUtils.underline2Camel(column_name)).append(" != null\">").append("\n");
                saveSqlKeySb.append("\t\t\t\t").append(column_name).append(",").append("\n");
                saveSqlKeySb.append("\t\t\t").append("</if>").append("\n");
                saveSqlValueSb.append("\t\t\t").append("<if test=\"").append(CamelUtils.underline2Camel(column_name)).append(" != null\">").append("\n");
                saveSqlValueSb.append("\t\t\t\t").append("#{").append(CamelUtils.underline2Camel(column_name)).append("}").append(",").append("\n");
                saveSqlValueSb.append("\t\t\t").append("</if>").append("\n");
            }
        }
        saveSqlKeySb.append("\t\t\t").append("create_time").append("\n");
        saveSqlValueSb.append("\t\t\t").append("NOW()").append("\n");
        sb.append(saveSqlKeySb);
        sb.append("\t\t").append(")");
        sb.append(" values ").append("(").append("\n");
        sb.append(saveSqlValueSb);
        sb.append("\t").append("</insert>").append("\n\n");
    }

    private static void appendResultMap(ResultSet colRet, StringBuilder sb, String camelTableName) throws Exception {
        StringBuilder resultMapSb = new StringBuilder();//resultMap
        resultMapSb.append("\t").append("<resultMap id = \"").append(RESULT_MAP).append("\" type=\"").append(PRE).append(".").append(ENETIY).append(".").append(camelTableName).append("\">").append("\n");
        colRet.beforeFirst();
        while (colRet.next()) {
            String column_name = colRet.getString("COLUMN_NAME");
            // <result property="gpsNo" column="gps_no"/>
            resultMapSb.append("\t\t").append("<result property=\"").append(CamelUtils.underline2Camel(column_name)).append("\" column=\"").append(column_name).append("\"/>").append("\n");
        }
        resultMapSb.append("\t").append("</resultMap>").append("\n\n");
        sb.append(resultMapSb);
    }

    private static void appendSql(ResultSet colRet, StringBuilder sb) throws Exception {
        colRet.beforeFirst();
        sb.append("\t").append("<sql id=\"" + SQL_COLUMN + "\">").append("\n");
        sb.append("\t\t");
        StringBuilder sqlColumnSb = new StringBuilder();//sql
        while (colRet.next()) {
            String column_name = colRet.getString("COLUMN_NAME");
            sqlColumnSb.append(column_name).append(",");
        }
        String sqlColumnStr = "";
        if (sqlColumnSb.lastIndexOf(",") != -1) {
            sqlColumnStr = sqlColumnSb.substring(0, sqlColumnSb.lastIndexOf(","));
        }
        sb.append(sqlColumnStr).append("\n");
        sb.append("\t").append("</sql>").append("\n\n");
    }

    public static void queryAndWriteMapper(ResultSet colRet, String camelTableName, String className, String primaryKeyColumnName) throws Exception {
        colRet.beforeFirst();
        String primaryKeyColumnType = "";
        while (colRet.next()) {
            //字段名
            String columnName = colRet.getString("COLUMN_NAME");
            if (columnName.equals(primaryKeyColumnName)) {
                //字段类型
                String columnType = colRet.getString("TYPE_NAME");
                primaryKeyColumnType = JavaSqlTypeEnums.getValue(columnType);
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("package ").append(PRE).append(".").append(MAPPER).append(";").append("\n\n");
        sb.append(IMPORT_MAPPER).append("\n");
        sb.append(IMPORT_PARAM).append("\n\n");
        sb.append("import ").append(PRE).append(".").append(ENETIY).append(".").append(camelTableName).append(";").append("\n\n");
        sb.append(IMPORT_LIST).append("\n\n");
        sb.append(ANNOTATION_MAPPER).append("\n");
        sb.append("public interface ").append(camelTableName + "Mapper").append("{").append("\n\n");
        sb.append("\t//保存").append("\n");
        sb.append("\t").append(camelTableName).append(" ").append("save" + camelTableName).append("(").append(ANNOTATION_PARAM).append("(\"").append(className).append("\") ").append(camelTableName + " ").append(className).append(");").append("\n\n");
        sb.append("\t//根据主键查询").append("\n");
        sb.append("\t").append(camelTableName).append(" ").append("query" + camelTableName + "ById").append("(").append(ANNOTATION_PARAM).append("(\"").append("id").append("\") ").append(" ").append(primaryKeyColumnType).append(" ").append("id").append(");").append("\n\n");
        sb.append("\t//批量查询").append("\n");
        sb.append("\t").append("List<").append(camelTableName).append(">").append(" queryList").append("();").append("\n\n");
        sb.append("\t//修改").append("\n");
        sb.append("\t").append("Integer").append(" ").append("update" + camelTableName).append("(").append(ANNOTATION_PARAM).append("(\"").append(className).append("\") ").append(camelTableName + " ").append(className).append(");").append("\n\n");
        sb.append("\t//根据主键删除").append("\n");
        sb.append("\t").append("Integer").append(" ").append("delete" + camelTableName + "ById").append("(").append(ANNOTATION_PARAM).append("(\"").append("id").append("\") ").append(" ").append(primaryKeyColumnType).append(" ").append("id").append(");").append("\n");
        sb.append("}");
        String file = "E://test3/" + MAPPER;
        String fileName = "/" + camelTableName + "Mapper.java";
        WriteStringToFile(file, fileName, sb.toString());
    }

    public static void queryAndWriteVo(ResultSet colRet, String camelTableName, String tableName) throws Exception {
        colRet.beforeFirst();
        Boolean hasDate = false;
        Boolean hasBigDecimal = false;
        Boolean hasBigInteger = false;
        Boolean hasTime = false;
        StringBuilder sb = new StringBuilder();
        sb.append("public ").append("class ").append(camelTableName).append("{").append("\n");
        while (colRet.next()) {
            String remarks = colRet.getString("REMARKS");

            //字段名
            String columnName = colRet.getString("COLUMN_NAME");
            String camel = CamelUtils.underline2Camel(columnName);

            //字段类型
            String columnType = colRet.getString("TYPE_NAME");
            String javaType = JavaSqlTypeEnums.getValue(columnType);
            if (StringUtils.isBlank(javaType)) {
                throw new UnsupportedOperationException("不支持的columnType :" + columnType + " 不支持的tableName :" + tableName);
            } else {
                if (StringUtils.isNotBlank(remarks)) {
                    sb.append("\t").append("@AutoDocProperty(value=\"").append(remarks).append("\")").append("\n");
                }
                sb.append("\t").append("private ").append(javaType).append(" ").append(camel).append(";").append("\n");
                if (javaType.equals("Date")) {
                    hasDate = true;
                }
                if (javaType.equals("BigDecimal")) {
                    hasBigDecimal = true;
                }
                if (javaType.equals("BigInteger")) {
                    hasBigInteger = true;
                }
                if (javaType.equals("Time")) {
                    hasTime = true;
                }
            }
        }
        sb.append("}");
        //System.out.println(sb);
        StringBuilder sb1 = new StringBuilder();
        sb1.append("package ").append(PRE).append(".").append(ENETIY).append(";").append("\n\n");
        sb1.append(IMPORT_LOMBOK).append("\n").append("\n");
        if (hasDate) {
            sb1.append(IMPORT_DATE).append("\n").append("\n");
        }
        if (hasBigDecimal) {
            sb1.append(IMPORT_BIGDECIMAL).append("\n").append("\n");
        }
        if (hasBigInteger) {
            sb1.append(IMPORT_BIGINTEGER).append("\n").append("\n");
        }
        if (hasTime) {
            sb1.append(IMPORT_TIME).append("\n").append("\n");
        }
        sb1.append(ANNOTATION_DATA).append("\n");
        sb1.append(sb);
        String file = "E://test3/" + ENETIY;
        String fileName = "/" + camelTableName + ".java";
        WriteStringToFile(file, fileName, sb1.toString());
    }

    public static void WriteStringToFile(String filePath, String fileName, String str) {
        PrintStream ps = null;
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                file.mkdirs();
            }
            File file1 = new File(filePath + "/" + fileName);
            if (!file1.exists()) {
                file1.createNewFile();

            }
            System.out.println("开始写入:" + fileName);
            ps = new PrintStream(new FileOutputStream(file1));
            ps.println(str);// 往文件里写入字符串
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ps.close();
        }
    }

}
