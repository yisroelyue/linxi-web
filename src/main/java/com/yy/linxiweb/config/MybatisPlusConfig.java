package com.yy.linxiweb.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.handler.TenantLineHandler;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.TenantLineInnerInterceptor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class MybatisPlusConfig {

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {

        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
//        //添加多租户拦截器
//        interceptor.addInnerInterceptor(createTenantInnerInterceptor());
//        //参数：new PaginationInnerInterceptor(DbType.MYSQL)，是专门为mysql定制实现的内部的分页插件
//        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
//        //添加：乐观锁插件
//        interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        return interceptor;
    }



}