package com.autoyol.api.filter;

/*import com.autuoyol.utils.web.ResponseObject;
import com.netflix.zuul.exception.ZuulException;*/
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {
    private final static Logger logger = LoggerFactory.getLogger(ErrorHandler.class);


   /* @ExceptionHandler(ZuulException.class)
    @ResponseBody
    ResponseEntity<?> handleControllerException(HttpServletRequest request, ZuulException ex) {
        HttpStatus status = getStatus(request);
        return new ResponseEntity<>( ResponseObject.error(status.toString(),ex.getMessage()),status);
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }
*/

}
