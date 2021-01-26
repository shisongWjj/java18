package com.ss.cut;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * AbstractAop
 *
 * @author shisong
 * @date 2021/1/21
 */
public abstract class AbstractAop {

    /**
     * 错误路径
     */
    /*private static final String ERROR_PREFIX = "/error";
    private static final String ERROR_PREFIX_V2 = "error";

    private static final String SPECIAL_CLASS = "org.apache.catalina.connector.RequestFacade";

    public void interceptor(JoinPoint jp){
        ServletRequestAttributes arr = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = arr.getRequest();
        String uri = request.getRequestURI();
        Object[] args = jp.getArgs();
        if (args == null || args.length < 1){
            return;
        }
        if(StringUtils.isBlank(uri)){
            return;
        }

        // 1: 一些Spring内部异常直接抛出
        if (uri.startsWith(ERROR_PREFIX) || uri.startsWith(ERROR_PREFIX_V2)) {
            return;
        }

        // 2: 打印参数 接口中有HttpServletRequest，也会转成JSON输出，转换的过程会报错
        for (Object obj : args) {
            if(!SPECIAL_CLASS.equals(obj.getClass().getName())){
                JsonUtils.printLog(JsonUtils.LOG_TYPE.PARAM, obj);
            }
        }
        // 3: 执行权限拦截
        if(meetTheConditions(uri)){
            this.buildSetMemInfo(request, args);
        }
    }

    *//**
     * 设置用户信息
     * @param request request
     * @param args 方法的入参
     *//*
    protected abstract void buildSetMemInfo(HttpServletRequest request, Object[] args);

    *//**
     * 满足条件
     * @param uri uri
     * @return 满足条件
     *//*
    protected abstract boolean meetTheConditions(String uri);*/
}
