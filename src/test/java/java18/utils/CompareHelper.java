package java18.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * CompareHelper
 *
 * @author shisong
 * @date 2020/1/7
 */
public class CompareHelper<T> {

    private T fromDB;

    private T fromApp;

    private Map<String,String> paramNames;

    @SuppressWarnings("unchecked")
    public CompareHelper(T fromDB, T fromApp, Map<String,String> paramNames) {
        if(fromDB == null){
            try {
                fromDB = (T) fromApp.getClass().newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.fromDB = fromDB;
        this.fromApp = fromApp;
        this.paramNames = paramNames;
    }

    public String compare() throws Exception{
        if(fromDB == null || fromApp == null || CollectionUtils.isEmpty(paramNames)){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String paramName : paramNames.keySet()) {
            String s = paramNames.get(paramName);
            String targetValue = getDeclaredFieldValueByField(fromDB, paramName);
            String sourceValue = getDeclaredFieldValueByField(fromApp, paramName);
            sb.append("将【");
            sb.append(s);
            sb.append("】从'");
            if(StringUtils.isNotBlank(targetValue) && !"null".equals(targetValue)){
                sb.append(targetValue);
            }
            sb.append("'改成'");
            sb.append(sourceValue);
            sb.append("';");
        }
        return sb.toString();
    }

    private String getDeclaredFieldValueByField(T t, String fieldName) throws Exception{
        Field field = t.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return String.valueOf(field.get(t));
    }


}
