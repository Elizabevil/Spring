package com.eliza.spring.druid.controller.redis

import com.eliza.spring.library.utils.redis.RedisOperator
import com.eliza.spring.library.utils.redis.RedisUtils
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.annotation.Resource


/*-*- coding:utf-8 -*-
 * @Author  : debi
 * @Time    : 5/18/22
 * @Software: IntelliJ IDEA
 */
@ComponentScan()
@RestController
@RequestMapping("/redis")
class RedisController {

    @Resource
    private val redisTemplate: RedisTemplate<String, String>? = null

    @Resource
    private lateinit var stringRedisTemplate: StringRedisTemplate

    @GetMapping("/set")
    fun set() {
        redisTemplate!!.opsForValue().set("name", "Asas")
    }

    @GetMapping("/get")
    fun get() {
        println(redisTemplate!!.opsForValue()["name"])
    }


    @GetMapping("/set1")
    fun set1() {
        redisTemplate!!.opsForValue().set("name", "set1")
    }

    @GetMapping("/get1")
    fun get1() {
        println(RedisOperator(stringRedisTemplate).get("name"))
    }

    @GetMapping("/set2")
    fun set2() {
        redisTemplate?.let { RedisUtils(it).set("name", "set2") }
    }

    @GetMapping("/get2")
    fun get2() {
        println(redisTemplate?.let { RedisUtils(it).get("name") })


    }
}