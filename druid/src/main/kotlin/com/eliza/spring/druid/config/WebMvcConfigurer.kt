package com.eliza.spring.druid.config

import com.eliza.spring.library.utils.jwt.JWTInterceptor
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer


/*-*- coding:utf-8 -*-
 * @Author  : debi
 * @Time    : 4/30/22
 * @Software: IntelliJ IDEA
 */
@Configuration
class CorsConfig : WebMvcConfigurer {
    override fun addCorsMappings(registry: CorsRegistry) {

        //添加映射路径
        registry.addMapping("/**") //是否发送Cookie
            .allowCredentials(true) //设置放行哪些原始域   SpringBoot2.4.4下低版本使用.allowedOrigins("*")
            .allowedOriginPatterns("*") //放行哪些请求方式
            .allowedMethods(*arrayOf("GET", "POST", "PUT", "DELETE")) //.allowedMethods("*") //或者放行全部
            //放行哪些原始请求头部信息
            .allowedHeaders("*") //暴露哪些原始请求头部信息
            .exposedHeaders("*")
    }

    /*将拦截器注入到MVC*/
    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(JWTInterceptor())
            //拦截的路径
            .addPathPatterns("/jwt/**")
            //排除登录接口
            .excludePathPatterns("/jwt/getJwtToken");
    }

}