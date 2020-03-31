package com.yaao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
/**
 * 事务管理
 */
@EnableTransactionManagement
/**
 * 扫描dao层
 */
@MapperScan("com.yaao.dao")
/**
 * 扫描servlet
 */
@ServletComponentScan("com.yaao.servlet")
/**
 * @author GuTianHao
 * 主类
 */
public class WeChatSpringBootApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(WeChatSpringBootApplication.class);
    }


    public static void main(String[] args) {
        SpringApplication.run(WeChatSpringBootApplication.class, args);
    }
}
