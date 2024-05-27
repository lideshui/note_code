package com.springboot.config;

import com.springboot.properties.JedisProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import redis.clients.jedis.Jedis;

//声明当前类是一个配置类
@SpringBootConfiguration
//批量注入
@EnableConfigurationProperties(JedisProperties.class)
public class JedisAutoConfiguration {

    @Autowired
    JedisProperties jedisProperties;

    @Bean
    public Jedis createJedis() {
        // 这里假设你有一个JedisProperties类来配置Jedis的参数  IP、端口
        Jedis jedis = new Jedis(jedisProperties.getHost(), jedisProperties.getPort());
        // 设置密码
        if (jedisProperties.getPassword() != null) {
            jedis.auth(jedisProperties.getPassword());
        }
        // 可以添加其他配置，如连接超时、读取超时等
        return jedis;
    }
}