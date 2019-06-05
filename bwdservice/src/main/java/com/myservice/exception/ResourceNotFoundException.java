package com.myservice.exception;

/**
* @ClassName: ResourceNotFoundException
* @Description: 资源不存在
* @author 再来一个芒果
* @date 2018年3月19日 下午12:17:42
* 
*/
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException() {
        super();
    }

    public ResourceNotFoundException(String message ) {
        super( message );
    }

    public ResourceNotFoundException(String message, Throwable cause ) {
        super( message, cause );
    }

    public ResourceNotFoundException(Throwable cause ) {
        super( cause );
    }

    protected ResourceNotFoundException(String message,
                                        Throwable cause,
                                        boolean enableSuppression,
                                        boolean writableStackTrace ) {
        super( message, cause, enableSuppression, writableStackTrace );
    }
}
