package com.ss.cut;

import com.autoyol.pcWebService.base.BaseRequest;
import com.autoyol.pcWebService.util.CharUtils;
import com.ss.base.BaseRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

/**
 * MemInfoForConsoleAop
 *
 * @author shisong
 * @date 2021/1/21
 */
//@Aspect
@Component
public class MemInfoForConsoleAop extends AbstractAop{

    private static final Logger LOGGER = LoggerFactory.getLogger(MemInfoForConsoleAop.class);


    /**
     * 后台管理URI的开始前缀
     */
    private static final String CONSOLE_PREFIX = "/console";
    /**
     * 后台权限用户
     */
    private static final Class<?> CONSOLE_CLAZZ = BaseRequest.class;
    /**
     * 后台用户昵称 Header
     */
    private static final String CONSOLE_AUTH_NAME = "Console-AUTH-Name";
    /**
     * 后台用户ID Header
     */
    private static final String CONSOLE_AUTH_ID = "Console-AUTH-ID";
    /**
     * 操作人
     */
    private static final String CONSOLE_FIELD_HANDLE_USER = "handleUser";
    /**
     * 操作人编号
     */
    private static final String CONSOLE_FIELD_HANDLE_USER_NO = "handleUserNo";

    /*@Pointcut("@annotation(com.autoyol.pcWebService.cut.MemInfoForConsole)")
    private void methodAop() {
    }

    @Before("methodAop()")
    @Override
    public void interceptor(JoinPoint jp){
        super.interceptor(jp);
    }

    @Override
    protected void buildSetMemInfo(HttpServletRequest request, Object[] args) {
        Object targetObj = null;
        Class<?> paramClazz = null;
        for (Object obj : args) {
            Class<?> pc = obj.getClass();
            if (CONSOLE_CLAZZ.isAssignableFrom(pc)) {
                paramClazz = pc;
                targetObj = obj;
                break;
            }
        }
        Object userName = request.getHeader(CONSOLE_AUTH_NAME);
        if (targetObj == null){
            return;
        }

        Object userNo = request.getHeader(CONSOLE_AUTH_ID);
        String userNameStr = null;
        if (userName != null) {
            try {
                userNameStr = CharUtils.decodeUrlCode(userName.toString());
            } catch (Exception e) {
                LOGGER.error("编码异常：", e);
            }
        }
        LOGGER.info("【Console】管理员：{}，编号：{}", userNameStr, userNo);

        try {
            // 1: 操作人编号
            if (userName != null) {
                PropertyDescriptor pd1 = new PropertyDescriptor(CONSOLE_FIELD_HANDLE_USER, paramClazz);
                Method m1 = pd1.getWriteMethod();
                m1.invoke(targetObj, userNameStr);
            }

            // 2: 操作编号
            if (userNo != null) {
                PropertyDescriptor pd1 = new PropertyDescriptor(CONSOLE_FIELD_HANDLE_USER_NO, paramClazz);
                Method m2 = pd1.getWriteMethod();
                m2.invoke(targetObj, Integer.parseInt(userNo.toString()));
            }
        } catch (Exception e) {
            LOGGER.error("【Console】户权限抓取执行异常", e);
        }
    }

    @Override
    protected boolean meetTheConditions(String uri) {
        return uri.startsWith(CONSOLE_PREFIX);
    }*/

}
