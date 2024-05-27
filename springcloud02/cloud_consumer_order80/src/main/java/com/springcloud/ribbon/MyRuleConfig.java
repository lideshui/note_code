package com.springcloud.ribbon;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;


@SpringBootConfiguration
public class MyRuleConfig {

    // 随机策略
    @Bean
    public IRule getRule(){
        return new RandomRule();
    }
}