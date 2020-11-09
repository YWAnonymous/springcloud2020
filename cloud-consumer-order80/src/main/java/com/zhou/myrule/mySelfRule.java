package com.zhou.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class mySelfRule {

    @Bean
    public IRule myRule(){
        return new RandomRule();
    }
}
