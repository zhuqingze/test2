package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    User getUser(){
        User user=new User("1","2","4");
        return user;
    }
}
