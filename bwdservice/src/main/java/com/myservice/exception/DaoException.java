package com.myservice.exception;

/**
* @ClassName: DaoException
* @Description: dao异常
* @author 再来一个芒果
* @date 2018年3月19日 下午12:17:17
* 
*/
public class DaoException extends RuntimeException {

    public DaoException() {
        super();
    }

    public DaoException(String message ) {
        super( message );
    }

    public DaoException(String message, Throwable cause ) {
        super( message, cause );
    }

    public DaoException(Throwable cause ) {
        super( cause );
    }

    protected DaoException(String message,
                           Throwable cause,
                           boolean enableSuppression,
                           boolean writableStackTrace ) {
        super( message, cause, enableSuppression, writableStackTrace );
    }
}
