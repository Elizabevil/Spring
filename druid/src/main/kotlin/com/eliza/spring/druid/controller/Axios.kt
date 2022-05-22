package com.eliza.spring.druid.controller

import com.alibaba.fastjson2.JSON
import com.alibaba.fastjson2.JSONObject
import com.eliza.spring.library.mapper.IUserMapper
import com.eliza.spring.library.model.User
import com.eliza.spring.library.utils.LogTools
import org.mybatis.spring.annotation.MapperScan
import org.springframework.context.annotation.ComponentScan
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import javax.annotation.Resource


/*-*- coding:utf-8 -*-
 * @Author  : debi
 * @Time    : 4/23/22
 * @Software: IntelliJ IDEA
 */
@Controller
@RequestMapping("/axios")
@MapperScan(basePackages = ["com.eliza.library.mapper"])
@ComponentScan()

class Axios {

    @Resource
    lateinit var iUserMapper: IUserMapper

    @GetMapping("/index")
    @RequestMapping("/index")
    fun index(): String {
        return "Axios/AV"
    }


    @RequestMapping("/sendData")
    @ResponseBody
    fun sendData(): List<User> {


        return iUserMapper.getAllUser()

        return arrayListOf<User>(
            User("a", 1),
            User("b", 2),
            User("c", 13),
            User("d", 4),
        )
    }

    @PostMapping("/getReqBody")
    @GetMapping("/getReqBody")
    @RequestMapping("/getReqBody")

//    @RequestMapping(value = ["/getReqBody"], method = [RequestMethod.POST])
    fun getReqBody(@RequestBody body: String): String {
        LogTools.LogPrintln("获取 Req 请求体", 11)
        LogTools.LogPrintln(body, 12)
        val jsonObject: JSONObject = JSON.parseObject(body)
        var user: User = JSON.parseObject(jsonObject.toJSONString(), User::class.java)
        LogTools.LogPrintln(user.toString())
        iUserMapper.insertUser(user)
        return "Axios/AV"
    }

    @PostMapping("/delUser")
    @GetMapping("/delUser")
    @RequestMapping("/delUser")

//    @RequestMapping(value = ["/delUser"], method = [RequestMethod.POST])
    fun delUser(@RequestBody body: String): String {
        LogTools.LogPrintln("获取 Req 请求体", 11)
        LogTools.LogPrintln(body, 12)
        val name = JSON.parseObject(body).getString("name")
        iUserMapper.deleteUser(name)
        return "Axios/AV"

    }

    //或者是实体对象接收
    @GetMapping("/updateUser")
    @PostMapping(path = ["/updateUser"])
    fun demo1(@RequestBody user: User) {
        LogTools.LogPrintln(user.toString())
    }


}