package com.leyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author: Darrick
 * @Date: 2019/7/4 10:55
 * @Description:springboot-demo启动类
 */
@SpringBootApplication
@MapperScan("com.leyou.mapper")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

}
