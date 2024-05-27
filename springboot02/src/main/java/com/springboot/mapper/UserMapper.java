package com.springboot.mapper;

import com.springboot.pojo.User;
import tk.mybatis.mapper.common.Mapper;

/**
 * @Description: 继承增强版的TKMapper，基础查询不需要再自己写了⚠️⚠️⚠️
 * @AllClassName: com.springboot.mapper.UserMapper
 */
public interface UserMapper extends Mapper<User> {
}