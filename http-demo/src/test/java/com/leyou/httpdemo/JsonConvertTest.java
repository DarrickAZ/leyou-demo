package com.leyou.httpdemo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.leyou.httpdemo.pojo.User;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Darrick
 * @Date: 2019/7/9 14:42
 * @Description:Json转换工具测试
 */
public class JsonConvertTest {

    //json处理工具
    private ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 对象转json字符串
     * @throws JsonProcessingException
     */
    @Test
    public void objToJsonStr() throws JsonProcessingException {
        User user = new User();
        user.setId(8L);
        user.setAge(21);
        user.setName("柳岩");
        user.setUserName("liuyan");
        // 序列化
        String json = objectMapper.writeValueAsString(user);
        System.out.println("json = " + json);
    }

    /**
     * json字符串转普通对象
     * @throws IOException
     */
    @Test
    public void objToJsonStrToObj() throws IOException {
        User user = new User();
        user.setId(8L);
        user.setAge(21);
        user.setName("柳岩");
        user.setUserName("liuyan");
        // 序列化
        String json = objectMapper.writeValueAsString(user);

        // 反序列化，接收两个参数：json数据，反序列化的目标类字节码
        User result = objectMapper.readValue(json, User.class);
        System.out.println("result = " + result);
    }

    /**
     * json字符串转集合（类型工厂）
     * @throws IOException
     */
    @Test
    public void jsonStrToArrayByFactory() throws IOException {
        User user = new User();
        user.setId(8L);
        user.setAge(21);
        user.setName("柳岩");
        user.setUserName("liuyan");

        // 序列化,得到对象集合的json字符串
        String json = objectMapper.writeValueAsString(Arrays.asList(user, user));

        // 反序列化，接收两个参数：json数据，反序列化的目标类字节码
        List<User> users = objectMapper.readValue(json, objectMapper.getTypeFactory().constructCollectionType(List.class, User.class));
        for (User u : users) {
            System.out.println("u = " + u);
        }
    }

    /**
     * json字符串转集合（TypeReference）
     * @throws IOException
     */
    @Test
    public void jsonStrToArrayByTypeRefer() throws IOException {
        User user = new User();
        user.setId(8L);
        user.setAge(21);
        user.setName("柳岩");
        user.setUserName("liuyan");

        // 序列化,得到对象集合的json字符串
        String json = objectMapper.writeValueAsString(Arrays.asList(user, user));

        // 反序列化，接收两个参数：json数据，反序列化的目标类字节码
        List<User> users = objectMapper.readValue(json, new TypeReference<List<User>>(){});
        for (User u : users) {
            System.out.println("u = " + u);
        }
    }

}
