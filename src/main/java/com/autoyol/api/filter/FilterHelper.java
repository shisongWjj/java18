package com.autoyol.api.filter;

import com.autoyol.api.util.JsonMapper;
/*import com.autuoyol.utils.web.ResponseObject;
import com.netflix.zuul.context.RequestContext;*/
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

public class FilterHelper {
    private final static Logger logger = LoggerFactory.getLogger(FilterHelper.class);

    public static final String CONSOLE_PREFIX_PATH="console";

    public static final String FILT_FLAG_NAME="isSuccess";

    public static final JsonMapper jsonMapper = JsonMapper.nonDefaultMapper();
    
    private FilterHelper(){}


    /*public static boolean isConsoleOperation() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String path = request.getServletPath();
        logger.info("path is {}",path);
        String[] pathParts = path.split("/");
//        logger.info("pathParts is {}", Arrays.toString(pathParts));
        if(pathParts.length>2){
            logger.trace("pathParts[1] is {}",pathParts[2]);
            if(CONSOLE_PREFIX_PATH.equalsIgnoreCase(pathParts[2])){
                logger.trace("Path is console path:{}",pathParts[2]);
                return true;
            }
        }
        return false;
    }

    public static boolean isNeedHandleRequest(){
        RequestContext context = RequestContext.getCurrentContext();
        Object flagObject = context.get(FILT_FLAG_NAME);
        if(flagObject!=null){
            boolean flag = (boolean)flagObject;
            if(!flag){
                return false;
            }
        }
        return true;
    }


    *//**
     * 根据错误代码通知返回信息
     * @param errorCode
     * @param message
     *//*
    public static void errorHandle(String errorCode,String message){
        RequestContext context = RequestContext.getCurrentContext();
        context.set("FILT_FLAG_NAME",false);
        context.setResponseStatusCode(200);
        context.addZuulResponseHeader("Content-Type","application/json; charset=UTF-8");
        ResponseObject responseObject = ResponseObject.error(errorCode,message);
        context.setResponseBody(jsonMapper.toJson(responseObject));
        context.setSendZuulResponse(false);
    }

    public static boolean isPublic(){
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String path = request.getServletPath();
        logger.info("path is {}",path);
        String[] pathParts = path.split("/");
        logger.info("pathParts is {}", Arrays.toString(pathParts));
        if(pathParts.length>2){
            logger.trace("pathParts[1] is {}",pathParts[2]);
            boolean h5PublicFlag = ("h5".equalsIgnoreCase(pathParts[2]) && "public".equalsIgnoreCase(pathParts[3]));
            if("public".equalsIgnoreCase(pathParts[2]) || h5PublicFlag){
                logger.trace("Path is public path:{}",pathParts[2]);
                return true;
            }
        }
        return false;
    }*/

    public  static  String getToken(HttpServletRequest request) {
        String token = request.getHeader("Atzuche-Token");

        token = StringUtils.trimToNull(token);

        String method = request.getMethod();

        if("GET".equalsIgnoreCase(method)&&token==null){
            String paramToken = request.getParameter("token");
            if(paramToken!=null){
                logger.info("paramToken is {}",paramToken);
                token = paramToken;
            }
        }
        return token;
    }
}
