package com.dandinglong.experiment.config;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import java.util.Properties;

/**
 * MyBatis扫描接口
 *
 * @author wangxq
 * @since 2016-06-03 14:46
 */
@Configuration
@AutoConfigureAfter(ReaderConfig.class)
public class ReaderMapperScannerConfig {

    @Bean(name = "readerMapperScannerConfigurer")
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("readerSessionFactory");
        mapperScannerConfigurer.setBasePackage("com.dandinglong.experiment.mapper");
        Properties properties = new Properties();
        properties.setProperty("mappers", "com.dandinglong.experiment.util.MyMapper");
        properties.setProperty("notEmpty", "false");
        properties.setProperty("IDENTITY", "MYSQL");
        mapperScannerConfigurer.setProperties(properties);
        return mapperScannerConfigurer;
    }

}
