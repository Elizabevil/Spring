package com.eliza.spring.library.model

import com.baomidou.mybatisplus.annotation.FieldFill
import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId


/*-*- coding:utf-8 -*-
 * @Author  : debi
 * @Time    : 4/19/22
 * @Software: IntelliJ IDEA
 */
class User() {
    @TableId(type = IdType.ASSIGN_ID)
    private val id: Long? = null
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private val time: Long? = null
    var name = ""
    var age = 0

    constructor(name: String, age: Int) : this() {
        this.name = name
        this.age = age
    }

    override fun toString(): String {
        return "Addr:${this::class.java.hashCode()}::User(name='$name', age=$age)"
    }


}