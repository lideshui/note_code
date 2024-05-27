package com.springboot.service.impl;

import com.springboot.mapper.UserMapper;
import com.springboot.pojo.User;
import com.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    //加满足条件则自动配置类，Spring自动生成的对象
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public List<User> findAll() {
        //从缓存中查询数据  规定存储用户信息使用string类型进行存储, 存储的key就是userList
        List<User> userList = (List<User>) redisTemplate.boundValueOps("userList").get();
        //如果缓存中没有数据, 查询数据库 , 将查询到的数据放入缓存
        if (userList==null){
            //如果是第一次访问就查询数据库
            userList = userMapper.selectAll();
            //将第一次查询到的用户放到Redis中
            redisTemplate.boundValueOps("userList").set(userList);
            System.out.println("查询的是数据库");
        }else {
            System.out.println("查询的是缓存");
        }
        return userList;
    }

    @Override
    public User getUserById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public void addUser(User user) {
        userMapper.insert(user);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateByPrimaryKey(user);
    }

    @Override
    public void deleteUser(Integer id) {
        userMapper.deleteByPrimaryKey(id);
    }
}