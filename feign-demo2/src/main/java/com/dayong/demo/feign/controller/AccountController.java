package com.dayong.demo.feign.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
    @GetMapping("test")
    public String testInvoke(@RequestParam String id) {
        if ("1".equals(id)) {
            //throw new BusinessException("不能为1");
            throw new RuntimeException("不能为1");
        }
        return "good job!";
    }
}
