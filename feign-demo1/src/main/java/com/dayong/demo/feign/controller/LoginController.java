package com.dayong.demo.feign.controller;

import com.dayong.demo.feign.remote.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class LoginController {
    @Resource
    AccountService accountService;

    @GetMapping("test")
    public String testInvoke(@RequestParam String id) {
        String result = accountService.testInvoke(id);
        return result;
    }
}
