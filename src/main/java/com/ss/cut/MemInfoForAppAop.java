package com.ss.cut;

import com.ss.base.ConsumerInfo;
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
public class MemInfoForAppAop extends AbstractAop{

    private static final Logger LOGGER = LoggerFactory.getLogger(MemInfoForAppAop.class);

    /**
     * 后台管理URI的开始前缀
     */
    private static final String CONSOLE_PREFIX = "/console";
    private static final String PUBLIC_PREFIX = "/public";
    private static final Class<?> MEM_USER_CLAZZ = ConsumerInfo.class;
    private static final String MEM_NO = "X-AUTH-ID";
    private static final String MEM_NICK_NAME = "X-AUTH-Nickname";
    private static final String MEM_REAL_NAME = "X-AUTH-RealName";
    private static final String MEM_USER_HEAD = "X-AUTH-ImagePath";
    // 字段
    private static final String MEM_FIELD_MEM_NO = "memNo";
    private static final String MEM_FIELD_REAL_NAME = "realName";
    private static final String MEM_FIELD_NICK_NAME = "nickName";
    private static final String MEM_FIELD_USER_HEAD = "userHead";

    /*@Pointcut("@annotation(com.autoyol.pcWebService.cut.MemInfoForApp)")
    private void methodAop() {
    }

    @Before("methodAop()")
    @Override
    public void interceptor(JoinPoint jp){
        super.interceptor(jp);
    }

    @Override
    protected void buildSetMemInfo(HttpServletRequest request, Object[] args) {
        Object memNo = request.getHeader(MEM_NO);
        Object nickName = request.getHeader(MEM_NICK_NAME);
        Object realName = request.getHeader(MEM_REAL_NAME);
        Object userHead = request.getHeader(MEM_USER_HEAD);
        String nickNameStr = null;
        Object realNameStr = null;
        Object userHeadStr = null;
        try {
            if (nickName != null){
                nickNameStr = CharUtils.decodeUrlCode(nickName.toString());
            }
            if (realName != null){
                realNameStr = CharUtils.decodeUrlCode(realName.toString());
            }
            if (userHead != null){
                userHeadStr = CharUtils.decodeUrlCode(userHead.toString());
            }
        } catch (Exception e) {
            LOGGER.error("编码异常：", e);
        }

        LOGGER.debug("【C端】--> 会员号：{}，昵称：{}，真实姓名：{}, 头像：{}", memNo, nickNameStr, realNameStr, userHeadStr);

        Object targetObj = null;
        Class<?> paramClazz = null;
        for (Object obj : args) {
            Class<?> pc = obj.getClass();
            if (MEM_USER_CLAZZ.isAssignableFrom(pc)) {
                paramClazz = pc;
                targetObj = obj;
                break;
            }
        }

        if (targetObj == null)
            return;

        try {
            // 1: 会员号
            PropertyDescriptor pd = new PropertyDescriptor(MEM_FIELD_MEM_NO, paramClazz);
            Method m1 = pd.getWriteMethod();
            if (memNo != null)
                m1.invoke(targetObj, memNo.toString());

            // 2: 会员昵称
            if (nickName != null) {
                pd = new PropertyDescriptor(MEM_FIELD_NICK_NAME, paramClazz);
                Method m2 = pd.getWriteMethod();
                m2.invoke(targetObj, nickNameStr);
            }

            // 3: 会员真名
            if (realName != null) {
                pd = new PropertyDescriptor(MEM_FIELD_REAL_NAME, paramClazz);
                Method m3 = pd.getWriteMethod();
                m3.invoke(targetObj, realNameStr);
            }

            // 4: 用户头像
            if (userHead != null) {
                pd = new PropertyDescriptor(MEM_FIELD_USER_HEAD, paramClazz);
                Method m4 = pd.getWriteMethod();
                m4.invoke(targetObj, userHeadStr);
            }
        } catch (Exception e) {
            LOGGER.error("C端】权限抓取执行异常", e);
        }
    }

    @Override
    protected boolean meetTheConditions(String uri) {
        return !uri.startsWith(CONSOLE_PREFIX) && !uri.startsWith(PUBLIC_PREFIX);
    }*/

}
