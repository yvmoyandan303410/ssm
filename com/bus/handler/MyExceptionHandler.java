package com.bus.handler;

import com.bus.Exceptions.MyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public String handler(Exception e){
        System.out.println("RuntimeException");
        e.printStackTrace();
        return "upload/error";
    }
    @ExceptionHandler(Exception.class)
    public String handler2(Exception e){
        System.out.println("Exception");
        e.printStackTrace();
        return "upload/error";
    }
    @ExceptionHandler(MyException.class)
    @ResponseBody
    public String handler3(Exception e) {
        System.out.println("====MyException");
        e.printStackTrace();
        return "500";
    }
}
