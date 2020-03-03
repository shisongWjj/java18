package com.autoyol.api;


/*import com.autoyol.utils.base.JsonMapper;
import com.autuoyol.utils.web.ResponseObject;
import com.autuoyol.utils.web.ServiceException;
import com.dianping.cat.Cat;*/
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
/*import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;*/
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 错误页面处理
 * @author andy.liang
 */
@Controller
public class ErrorPageController /*implements ErrorController*/ {

    private static Logger logger = LoggerFactory.getLogger(ErrorPageController.class);

    @Value("${error.path:/error}")
    private String errorPath;

   /* private JsonMapper jsonMapper = new JsonMapper();

    private ErrorAttributes errorAttributes = new DefaultErrorAttributes();

    @RequestMapping(value = "${error.path:/error}", produces = "application/json; charset=UTF-8")
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseObject handle(HttpServletRequest request) {
        Map<String, Object> attributes = getErrorAttributes(request);

        Exception exception = (Exception)request.getAttribute("javax.servlet.error.exception");

        ResponseObject result = null;

        if(exception!=null&&exception.getCause()!=null){
            Throwable error = exception.getCause();
            if(error instanceof ServiceException){
                ServiceException serviceException = (ServiceException)error;
                Cat.logError("ServiceException",exception);
                result = ResponseObject.error(serviceException.getCode(),serviceException.getMsg());
            }else {
                //result = ResponseObject.error("200008", exception.getCause().getMessage());
                Cat.logError("系统错误",exception);
                result = ResponseObject.error("999999","系统错误");
            }
        }else{
            result = ResponseObject.error("999999","系统错误");
        }

        logError(attributes, request);

        return result;
    }

    private Map<String, Object> getErrorAttributes(HttpServletRequest request) {
        RequestAttributes requestAttributes = new ServletRequestAttributes(request);
        return this.errorAttributes.getErrorAttributes(requestAttributes, false);
    }

    private void logError(Map<String, Object> attributes, HttpServletRequest request) {
        attributes.put("from", request.getRemoteAddr());
        logger.error(jsonMapper.toJson(attributes));
    }

    @Override
    public String getErrorPath() {
        return this.errorPath;
    }

    public static void main(String[] args) {
        System.out.println(HttpStatus.UNAUTHORIZED.getReasonPhrase());
    }*/
}
