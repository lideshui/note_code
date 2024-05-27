package com.springboot.service;

import com.springboot.pojo.User;
import java.util.List;


public interface UserService {
    /**
     * 查询所有实例信息
     */
    List<User> findAll();

    /**
     * 根据id获取实例
     */
    User getUserById(Integer id);

    /**
     * 添加实例
     */
    void addUser(User user);

    /**
     * 更新实例
     */
    void updateUser(User user);

    /**
     * 删除实例
     */
    void deleteUser(Integer id);
}
