package com.leyou.userconsumer.pojo;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: Darrick
 * @Date: 2019/7/5 11:42
 * @Description:tb_user表实体类
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    //主键id
    private Integer id;
    //用户名
    private String username;
    //密码
    private String password;
    //手机号
    private String phone;
    //创建日期
    private Date created;


}
