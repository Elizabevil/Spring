package com.eliza.spring.vue.controller

import com.eliza.spring.library.mapper.IUserMapper
import org.mybatis.spring.annotation.MapperScan
import org.springframework.context.annotation.ComponentScan
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import javax.annotation.Resource


/*-*- coding:utf-8 -*-
 * @Author  : debi
 * @Time    : 4/19/22
 * @Software: IntelliJ IDEA
 */
//@SpringBootApplication(scanBasePackages = {"com.example"})
@MapperScan(basePackages = ["com.eliza.spring.library.mapper"])
@ComponentScan()
@RequestMapping("/import")
@Controller
class ImportUserController {

    @Resource
    lateinit var iUserMapper: IUserMapper


    @ResponseBody
    @GetMapping("/getAll")
    fun getUsersAll(): String {
//        Tools.LogPrintln(iUserMapper.getUsersByName("b"), 3)
        return "${iUserMapper.getAllUser()}"
    }

}
