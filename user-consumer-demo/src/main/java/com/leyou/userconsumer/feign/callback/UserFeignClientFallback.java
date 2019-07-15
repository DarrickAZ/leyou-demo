package com.leyou.userconsumer.feign.callback;

import com.leyou.userconsumer.feign.UserFeignClient;
import com.leyou.userconsumer.pojo.User;
import org.springframework.stereotype.Component;

@Component
public class UserFeignClientFallback implements UserFeignClient {
    @Override
    public User queryUserById(Integer id) {
        User user = new User();
        user.setId(id);
        user.setUsername("用户查询出现异常！");
        return user;
    }
}