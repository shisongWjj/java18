package com.autoyol.api.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ReflectionUtils;

public class CustomErrorFilter extends ZuulFilter {
    private final static Logger logger = LoggerFactory.getLogger(CustomErrorFilter.class);
    
    @Override
    public String filterType() {
        return "error";
    }

    @Override
    public int filterOrder() {
        return -1;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext context = RequestContext.getCurrentContext();
        Throwable t = context.getThrowable();
        logger.info("error found: {}",t);
        if(t!=null){
            return true;
        }
        return false;

    }

    @Override
    public Object run() {
        try {
            RequestContext ctx = RequestContext.getCurrentContext();
            Object e = ctx.getThrowable();

            if (e != null && e instanceof ZuulException) {
                ZuulException zuulException = (ZuulException)e;
                logger.error("Zuul failure detected: " + zuulException.getMessage(), zuulException);

                // Populate context with new response values
                ctx.set("sendErrorFilter.ran",true);
                ctx.setResponseBody("{'xx':'bb'}");
                ctx.getResponse().setContentType("application/json");
                ctx.setResponseStatusCode(500); //Can set any error code as excepted
            }
        }
        catch (Exception ex) {
            logger.error("Exception filtering in custom error filter", ex);
            ReflectionUtils.rethrowRuntimeException(ex);
        }
        return null;
    }
}
