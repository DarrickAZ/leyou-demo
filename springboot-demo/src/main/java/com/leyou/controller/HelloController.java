package com.leyou.controller;

import com.leyou.pojo.User;
import com.leyou.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: Darrick
 * @Date: 2019/7/4 10:57
 * @Description:controller测试
 */
@Controller
public class HelloController {

    private Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    //@Autowired
    //private DataSource dataSource;

    @Autowired
    private UserService userService;

    @GetMapping("hello")
    @ResponseBody
    public User hello() {
        // LOGGER.info("HelloController hello()");
        User user = this.userService.queryById(16);
        return user;
    }

    /**
     * 返回所有用户信息数据
     */
    @GetMapping("/all")
    public String all(ModelMap modelMap) {
        //查询所有用户
        List<User> users = this.userService.queryAll();
        //放入模型
        modelMap.put("users",users);
        //返回模板名称（就是classpath:/templates/目录下的html文件名）
        return "users";
    }


}
