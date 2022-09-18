package com.example.shops.config;

import com.example.shops.service.DtoManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public DtoManager dtoManager(){
        return new DtoManager();
    }
}
