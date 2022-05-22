package com.eliza.spring.druid.controller.jwt

import com.eliza.spring.library.utils.jwt.JwtTools
import com.eliza.spring.library.utils.jwt.JwtTools.JWT_TOKEN
import com.eliza.spring.library.utils.LogTools
import com.eliza.spring.library.utils.redis.RedisOperator
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.annotation.Resource
import javax.servlet.http.HttpServletRequest


/*-*- coding:utf-8 -*-
 * @Author  : debi
 * @Time    : 5/3/22
 * @Software: IntelliJ IDEA
 */
@RestController
@RequestMapping("/jwt")
class JwtController {
    @Resource
    private lateinit var stringRedisTemplate: StringRedisTemplate
    @Resource
    private val redisTemplate: RedisTemplate<String, String>? = null


    @GetMapping("/getJwtToken")
    fun getJwtToken(): HashMap<String, Any> {
        val jwtCreat = JwtTools.JwtCreat(JWT_TOKEN, HashMap<String, String>().apply {
            put("as", "As")

            RedisOperator(stringRedisTemplate).set("as", "As")
        }, 100)

        return HashMap<String, Any>().apply {
            jwtCreat.let { put("token", it) }
            put("state", true)
            put("msg", "认证成功")

        }
    }

    @PostMapping("/Verify")
    fun Verify(req: HttpServletRequest): HashMap<String, Any> {
        LogTools.LogPrintln(req.getHeader("token"), 12)
        JwtTools.Verify(JWT_TOKEN, req.getHeader("token") ?: "")
        return HashMap<String, Any>().apply {
            put("state", true);
            put("msg", "请求成功");
            RedisOperator(stringRedisTemplate).get("as")?.let { put("redis", it) }

        }

    }
}