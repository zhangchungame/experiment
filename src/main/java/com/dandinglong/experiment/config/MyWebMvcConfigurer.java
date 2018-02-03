package com.dandinglong.experiment.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyWebMvcConfigurer extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new StudentInterceptor()).addPathPatterns("/student/**");
        registry.addInterceptor(new TeacherInterceptor()).addPathPatterns("/teacher/**");
        super.addInterceptors(registry);
    }
}
