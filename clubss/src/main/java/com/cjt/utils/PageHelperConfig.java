package com.cjt.utils;


import com.github.pagehelper.PageHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PageHelperConfig {
    @Bean
    public PageHelper createPaeHelper() {
        PageHelper page = new PageHelper();
        return page;
    }
}
