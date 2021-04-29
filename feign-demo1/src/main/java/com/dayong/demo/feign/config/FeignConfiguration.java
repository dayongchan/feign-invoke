package com.dayong.demo.feign.config;

import com.alibaba.fastjson.JSON;
import com.dayong.demo.feign.common.Result;
import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class FeignConfiguration {
    @Bean
    public ErrorDecoder errorDecoder() {
        return new MyFeignErrorDecoder();
    }

    public class MyFeignErrorDecoder implements ErrorDecoder {
        private Logger logger = LoggerFactory.getLogger(getClass());

        @Override
        public Exception decode(String methodKey, Response response) {
            Exception exception = null;
            try {
                int status = response.status();
                if (status != 200) {
                    String json = Util.toString(response.body().asReader());
                    Result result = JSON.parseObject(json, Result.class);
                    exception = new RuntimeException(result.getMsg(), result.getCause());
                }
            } catch (IOException ex) {
                logger.error(ex.getMessage(), ex);
            }
            return exception;
        }
    }
}
