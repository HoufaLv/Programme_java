package com.ksit.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

/**
 * 使用该注解来标记所有异常为全局异常
 * @author Lvhoufa
 */
@ControllerAdvice
public class ControllerException extends RuntimeException {

    /**
     * 将捕获所有Throwable 的异常
     * 然后跳转到error下面的500.jap
     * @return
     */
    @ExceptionHandler(Throwable.class)
    public String ioException(){
        return "error/500";
    }
}
