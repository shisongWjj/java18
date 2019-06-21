package com.ss.design.pattern.structural.proxy.db;

/**
 * DataSourceContextHolder
 *
 * @author shisong
 * @date 2019/1/17
 */
public class DataSourceContextHolder {

    public static final ThreadLocal<String> DBTYPE = new ThreadLocal<>();

    public static void setDbtype(String dbtype) {
        DBTYPE.set(dbtype);
    }

    public static String getDbtype() {
        return DBTYPE.get();
    }

    public static void removeDbtype() {
        DBTYPE.remove();
    }

}
