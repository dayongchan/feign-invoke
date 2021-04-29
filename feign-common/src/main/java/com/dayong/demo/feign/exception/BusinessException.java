package com.dayong.demo.feign.exception;

public class BusinessException extends RuntimeException {
    public BusinessException(String str) {
        super(str);
    }
}
