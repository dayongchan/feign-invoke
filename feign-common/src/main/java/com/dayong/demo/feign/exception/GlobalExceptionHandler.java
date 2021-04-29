package com.dayong.demo.feign.exception;

import com.dayong.demo.feign.common.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


@ControllerAdvice
public class GlobalExceptionHandler {
    Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<Result> defaultExceptionHandler(Exception e, HttpServletRequest request) throws Exception {
        String uri = request.getRequestURI();
        if (e instanceof BusinessException) {
            return new ResponseEntity<Result>(Result.fail(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
        logger.error("GlobalExceptionHandler defaultExceptionHandler. req url {}", uri);
        logger.error(e.getMessage(), e);
        return new ResponseEntity<Result>(Result.fail(e.getMessage(), e), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}