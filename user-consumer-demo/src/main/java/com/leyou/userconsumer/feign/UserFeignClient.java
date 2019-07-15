package com.leyou.userconsumer.feign;

import com.leyou.userconsumer.feign.callback.UserFeignClientFallback;
import com.leyou.userconsumer.feign.config.FeignConfig;
import com.leyou.userconsumer.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "user-service",fallback = UserFeignClientFallback.class,configuration = FeignConfig.class)
public interface UserFeignClient {

    @GetMapping("/user/{id}")
    User queryUserById(@PathVariable("id") Integer id);
}