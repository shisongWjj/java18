package com.autoyol.api.exception;

/**
 * 服务类异常
 */
public class AutoServiceException extends RuntimeException{
    private String errorCode;
    private String errorMsg;


    public AutoServiceException(String errorCode,String errorMsg){
        super();
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public AutoServiceException(String errorCode,String errorMsg,Throwable t){
        super(t);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }
}
