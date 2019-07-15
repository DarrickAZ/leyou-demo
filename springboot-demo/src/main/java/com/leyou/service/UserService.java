package com.leyou.service;

import com.leyou.mapper.UserMapper;
import com.leyou.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: Darrick
 * @Date: 2019/7/5 11:25
 * @Description:
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    //根据主键id查询
    public User queryById(Integer id){
       return this.userMapper.selectByPrimaryKey(id);
    }

    //查询所有
    public List<User> queryAll(){
        return this.userMapper.selectAll();
    }

    //根据主键进行删除
    @Transactional
    public void deleteById(Long id){
        this.userMapper.deleteByPrimaryKey(id);
    }


}
