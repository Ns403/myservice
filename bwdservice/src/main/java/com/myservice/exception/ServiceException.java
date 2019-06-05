package com.myservice.exception;

/**
* @ClassName: ServiceException
* @Description: service异常
* @date 2018年3月19日 下午12:17:57
* 
*/
public class ServiceException extends RuntimeException {

    public ServiceException() {
        super();
    }

    public ServiceException(String message ) {
        super( message );
    }

    public ServiceException(String message, Throwable cause ) {
        super( message, cause );
    }

    public ServiceException(Throwable cause ) {
        super( cause );
    }

    protected ServiceException(String message,
                               Throwable cause,
                               boolean enableSuppression,
                               boolean writableStackTrace ) {
        super( message, cause, enableSuppression, writableStackTrace );
    }
}
