package com.autoyol.mybatis.encrypt.intercept;

import com.autoyol.mybatis.encrypt.annotation.EncryptField;
import com.autoyol.mybatis.encrypt.util.EncryptUtil;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.plugin.*;

import java.lang.reflect.Field;
import java.sql.Statement;
import java.util.Collection;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Intercepts({@Signature(type = ResultSetHandler.class, method = "handleResultSets", args = {Statement.class})})
public class ResultDecryptSetInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object resultObject = invocation.proceed();
        if (resultObject == null) {
            return null;
        }
        List resultList = (List) resultObject;
        if (notEmpty(resultList)) {
            List<Field> fields = findEncryptStringFields(resultList.get(0));
            if (notEmpty(resultList)) {
                for (Object result : resultList) {
                    for (Field field : fields) {
                        field.setAccessible(true);
                        field.set(result, EncryptUtil.decrypt((String) (field.get(result))));
                    }
                }
            }
        }
        return resultObject;
    }

    private boolean notEmpty(Collection c) {
        return c != null && c.size() > 0;
    }

    private List<Field> findEncryptStringFields(Object o) {
        return Stream.of(o.getClass().getDeclaredFields())
                .filter(field -> String.class == field.getType() && field.isAnnotationPresent(EncryptField.class))
                .collect(Collectors.toList());
    }


    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}