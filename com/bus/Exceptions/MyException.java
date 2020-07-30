package com.bus.Exceptions;

public class MyException extends Exception{
    public MyException() {
        super();
        System.out.println("hello");
    }

    public MyException(String message) {
        super(message);
        System.out.println("hello");
    }

    public MyException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyException(Throwable cause) {
        super(cause);
    }

    protected MyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
