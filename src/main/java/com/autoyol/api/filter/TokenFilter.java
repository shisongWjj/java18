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
import java.util.Arrays;
import java.util.List;

/**
 * 检查请求头中是否有token且token是否合法。只有token存在且合法才允许访问到达后端
 */
public class TokenFilter /*extends ZuulFilter*/ {

    private final static List<String> EXCEPT_PATHS= Arrays.asList(
        "/authorization/user/auth/image/validCode",
        "/evaluationRecordList/get",
        "/ques/saveQuesAnswer",
        "/home/page",
        "/front/getQuesOpenStatus",
        "/front/checkUnitCode",
        "/front/getCity",
        "/front/getOptionalTime",
        "/front/newOrder",
        "/front/checkHasOrder",
        "/front/package/pre/rent",
        "/front/package/req",
        "/front/package/cancel",
        "/front/reminderCalendar",
        "/front/settingReminder",
        "/front/getQrCode",
        "/front/bindOpenId",
        "/ques/getUserToken",
        "/health"
//        "/evaluationRecord/add"

    );

    private final static Logger logger = LoggerFactory.getLogger(TokenFilter.class);

    private final TokenService tokenService;

    public TokenFilter(TokenService tokenService) {
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
        return !(FilterHelper.isConsoleOperation()|| FilterHelper.isPublic());
    }

    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();

        String realIp=request.getHeader("X-Real-IP");
        logger.info("realIp is : {}",realIp);
        String xForwardIp = request.getHeader("X-Forwarded-For");
        logger.info("xForwardIp is {}",xForwardIp);

        context.addZuulRequestHeader("X-Real-IP",realIp);

        String token = FilterHelper.getToken(request);


        if(token!=null){
            logger.info("token is {}",token);
            if("00o36cw7z37hk3j2fososlbiaqi1fsaw".equals(token)){
                logger.info("通过检查，token来自固定值");
                 context.addZuulRequestHeader("X-AUTH-ID","000000");
                return null;
            }
            MemViewEntity memEntity = tokenService.getMemInfo(token);
            boolean isValid =false;

            if(memEntity!=null){
                isValid=true;
            }
            if(isValid){
                logger.info("通过检查，token合法,memEntity is {}",memEntity);


                context.addZuulRequestHeader("X-AUTH-ID",memEntity.getId().toString());
                try {
                    //TODO: nickname
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

                logger.info("头部信息设置完成");
                return null;
            }else{
                //TODO:没有通过检查
                logger.info("登录失效 :{}",token);
                FilterHelper.errorHandle("200008","网关登录失效");
                return null;

            }

        }
        else if(isNoTokenPath(request)){
            logger.info("该路径不需要token也可以访问,path is {}",request.getServletPath());
            context.addZuulRequestHeader("X-AUTH-ID","000000");
            return null;
        }
        else {
            logger.info("token doesn't exist");
           //TODO:抛出错误，指示前端需要有token
            FilterHelper.errorHandle("200008","网关登录失效");
            return null;
        }
    }*/


    public boolean isNoTokenPath(HttpServletRequest request){
        String path = request.getServletPath();
        path = path.substring(path.indexOf("/", 2)).trim();
        logger.info("after remove service name ,path is {}",path);
        if(EXCEPT_PATHS.contains(path)){
            return true;
        }
        return false;

    }
}
