package com.autoyol.api.filter;

import com.autoyol.api.service.AuthService;
/*import com.autoyol.cas.util.ErrorCode;
import com.autoyol.cas.util.JwtUtil;
import com.autoyol.cas.vo.TokenVo;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;*/
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.net.URLEncoder;

/**
 * 用于拦截管理后台的访问请求
 */
public class JwtTFilter /*extends ZuulFilter*/ {

    private final static Logger logger = LoggerFactory.getLogger(JwtTFilter.class);

    @Autowired
    private AuthService authService;

   /* @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        if(!FilterHelper.isNeedHandleRequest()){
            return false;
        }
        return FilterHelper.isConsoleOperation();
    }

    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String auth = request.getHeader("Authorization");
        *//**
        if(StringUtils.isBlank(auth)) {
            logger.info("get from cookies");
            Cookie[] cookies = request.getCookies();
            if(null!=cookies && cookies.length>0) {
                for(Cookie cookie : cookies) {
                    if(cookie.getName().equals(CasFilter.JWT_COOKIE_KEY)) {
                        auth = cookie.getValue();
                        break;
                    }
                }
            }
        }**//*

        String method=request.getMethod();
        logger.info("method is {},auth is {}",method,auth);
        if("GET".equalsIgnoreCase(method)){
            String paramJwt = request.getParameter("jwt");
            if(paramJwt!=null){
                logger.info("paramJwt is {}",paramJwt);
                auth = paramJwt;
            }
        }
        
        boolean isAjax = false;
        String ajaxRequest = request.getHeader("X-Requested-With");
        if(null!=ajaxRequest && ajaxRequest.trim().length()>0) {
            isAjax = true;
        } else {
            String contentType = request.getHeader("Content-Type");
            if(null!=contentType && contentType.indexOf("application/json")>=0) {
                isAjax = true;
            }
        }
        logger.info("isAjax is {}",isAjax);
        TokenVo token = JwtUtil.parse(auth);
        if(null == token) {
            logger.warn("没有登录，对管理员系统操作");
            FilterHelper.errorHandle("200008",ErrorCode.LOGIN_UNLOGIN.getText());
            return null;
        } else if(JwtUtil.isTimeout(token.getLoginTime())) {
//            ec = ErrorCode.LOGIN_TIMEOUT;// 超时未登录
            logger.warn("超时未登录，对管理员系统操作");
            FilterHelper.errorHandle("200008",ErrorCode.LOGIN_TIMEOUT.getText());
            return null;
        } else {
        	boolean hasAuth = false;
        	Integer isAdmin = token.getIsAdmin();
        	if(null!=isAdmin && isAdmin==1) {
        		hasAuth = true;
        	} else {
        		hasAuth = authService.hasAuth(request.getMethod(), request.getServletPath(), token.getLoginId());
        	}
        	if(!hasAuth) {
        		logger.warn("无操作权限，对管理员系统操作");
                FilterHelper.errorHandle("200009",ErrorCode.LOGIN_UNAUTH.getText());
                return null;
        	}
        	try {
                context.addZuulRequestHeader("Console-AUTH-Name",URLEncoder.encode(token.getLoginName(),"utf-8"));
                context.addZuulRequestHeader("Console-AUTH-ID",URLEncoder.encode(token.getLoginId(),"utf-8"));
        	}catch(Exception e) {
        		logger.error("新网关后台console路由时header设定失败",e);
        	}
        }
        return null;
    }*/

    
}
