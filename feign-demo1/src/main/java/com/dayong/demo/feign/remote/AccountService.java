package com.dayong.demo.feign.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "feign-demo2")
public interface AccountService {
    @GetMapping("test")
    String testInvoke(@RequestParam String id);
}
