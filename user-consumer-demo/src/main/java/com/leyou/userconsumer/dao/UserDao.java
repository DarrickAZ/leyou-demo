package com.leyou.userconsumer.dao;

import com.leyou.userconsumer.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: Darrick
 * @Date: 2019/7/9 16:50
 * @Description:
 */
@Component
public class UserDao {

    private static final Logger logger = LoggerFactory.getLogger(UserDao.class);

    @Autowired
    private RestTemplate restTemplate;

    //public User queryUserById(Integer id){
    //    String url = "http://localhost:8081/user/"+id;
    //    return this.restTemplate.getForObject(url,User.class);
    //}

    /**
     * 测试Hystrix熔断
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "queryUserByIdFallback")
    public User queryUserById(Integer id){
        logger.info("queryUserById id ：{}", id);
        long begin = System.currentTimeMillis();
        String url = "http://user-service/user/" + id;
        User user = this.restTemplate.getForObject(url, User.class);
        long end = System.currentTimeMillis();
        // 记录访问用时：
        logger.info("访问用时：{}", end - begin);
        return user;
    }

    /**
     * Hystrix熔断失败回滚处理函数
     * @param id
     * @return
     */
    public User queryUserByIdFallback(Integer id){
        System.out.println("queryUserByIdFallback>>>>>>>>>>>>>>>>>>");
        User user = new User();
        user.setId(id);
        user.setUsername("用户信息查询出现异常！");
        return user;
    }


}
