package com.leyou.userconsumer.service;

import com.leyou.userconsumer.dao.UserDao;
import com.leyou.userconsumer.feign.UserFeignClient;
import com.leyou.userconsumer.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Darrick
 * @Date: 2019/7/9 16:54
 * @Description:
 */
@Service
public class UserService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserDao userDao;

    @Autowired
    private DiscoveryClient discoveryClient;// Eureka客户端，可以获取到服务实例信息

    @Autowired
    private UserFeignClient userFeignClient;

    /**
     * 按id集合进行查询
     */
    //public List<User> queryUserByIds(List<Integer> ids){
    //    List<User> users = new ArrayList<>();
    //    for (Integer id : ids) {
    //        User user = userDao.queryUserById(id);
    //        users.add(user);
    //    }
    //    return users;
    //}


    /**
     * 按id集合进行查询(eureka方式)
     */
    //public List<User> queryUserByIds(List<Integer> ids){
    //    List<User> users = new ArrayList<>();
    //    // String baseUrl = "http://localhost:8081/user/";
    //    // 根据服务名称，获取服务实例
    //    List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
    //    ServiceInstance instance = instances.get(0);
    //    // 获取ip和端口信息
    //    String baseUrl = "http://"+instance.getHost() + ":" + instance.getPort()+"/user/";
    //    ids.forEach(id ->{
    //        // 我们测试多次查询，
    //        users.add(this.restTemplate.getForObject(baseUrl + id, User.class));
    //        // 每次间隔500毫秒
    //        try {
    //            Thread.sleep(500);
    //        } catch (InterruptedException e) {
    //            e.printStackTrace();
    //        }
    //    });
    //    return users;
    //}

    /**
     * 按id集合进行查询(ribbon负载均衡方式)
     */
    //public List<User> queryUserByIds(List<Integer> ids){
    //    List<User> users = new ArrayList<>();
    //    // String baseUrl = "http://localhost:8081/user/";
    //    // 地址直接写服务名称即可
    //    String baseUrl = "http://user-service/user/";
    //    ids.forEach(id ->{
    //        // 我们测试多次查询，
    //        users.add(this.restTemplate.getForObject(baseUrl + id, User.class));
    //        // 每次间隔500毫秒
    //        try {
    //            Thread.sleep(500);
    //        } catch (InterruptedException e) {
    //            e.printStackTrace();
    //        }
    //    });
    //    return users;
    //}

    /**
     * Hystrix熔断方式
     * @param ids
     * @return
     */
    //public List<User> queryUserByIds(List<Integer> ids){
    //    List<User> users = new ArrayList<>();
    //    ids.forEach(id ->{
    //        //测试多次查询
    //        users.add(this.userDao.queryUserById(id));
    //    });
    //    return users;
    //}

    /**
     * Feign实现方式
      * @param ids
     * @return
     */
    public List<User> queryUserByIds(List<Integer> ids){
        List<User> users = new ArrayList<>();
        ids.forEach(id ->{
            //测试多次查询
            users.add(this.userFeignClient.queryUserById(id));
        });
        return users;
    }



}
