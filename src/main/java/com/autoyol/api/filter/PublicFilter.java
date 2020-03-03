package com.autoyol.api.filter;

import com.autoyol.api.entity.MemViewEntity;
import com.autoyol.api.service.TokenService;
/*import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;*/
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.net.URLEncoder;

/**
 * 对前缀是public的路径进行过滤处理
 */
public class PublicFilter /*extends ZuulFilter*/ {
    private final static Logger logger = LoggerFactory.getLogger(PublicFilter.class);

    private final TokenService tokenService;

    public PublicFilter(TokenService tokenService) {
        this.tokenService = tokenService;
    }
    
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
        return FilterHelper.isPublic();
    }

    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();

//        Enumeration<String> headerNames = request.getHeaderNames();
//        while(headerNames.hasMoreElements()){
//            String headerName = headerNames.nextElement();
//            logger.info("headerName is : {},value is {}",headerName,request.getHeader(headerName));
//        }
//
//        logger.info("request.remote is {},requestHost is {}",request.getRemoteAddr(),request.getRemoteHost());
//
        String realIp=request.getHeader("X-Real-IP");
        logger.info("realIp is : {}",realIp);
        String xForwardIp = request.getHeader("X-Forwarded-For");
        logger.info("xForwardIp is {}",xForwardIp);
        context.addZuulRequestHeader("X-Real-IP",realIp);


        String token = FilterHelper.getToken(request);


        if(token!=null){
            MemViewEntity memEntity = tokenService.getMemInfo(token);
            boolean isValid =false;

            if(memEntity!=null){
                isValid=true;
            }
            if(isValid){
                logger.info("通过检查，token合法 memEntity is {}",memEntity);
                context.addZuulRequestHeader("X-AUTH-ID",memEntity.getId());
                try {
                	if(StringUtils.isNotEmpty(memEntity.getNickname())) {
                        context.addZuulRequestHeader("X-AUTH-Nickname", URLEncoder.encode(memEntity.getNickname(), "utf-8"));
                	}
	                if(StringUtils.isNotEmpty(memEntity.getRealName())) {
	                    context.addZuulRequestHeader("X-AUTH-RealName", URLEncoder.encode(memEntity.getRealName(), "utf-8"));
                	}
	                if(StringUtils.isNotEmpty(memEntity.getImagePath())) {
	                    context.addZuulRequestHeader("X-AUTH-ImagePath", URLEncoder.encode(memEntity.getImagePath(), "utf-8"));
                	}

                }catch (Exception e){
                    logger.warn("encode error  ",e);
                }
                //image
                return null;
            }else{
                logger.info("token不合法，但是该路径没有强制要求: {}",request.getPathInfo());
                return null;

            }

        }

        return null;
    }*/


}
