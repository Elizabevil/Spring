package com.eliza.spring.library.mapper.plus

import com.baomidou.mybatisplus.core.conditions.Wrapper
import com.baomidou.mybatisplus.core.mapper.BaseMapper
import com.baomidou.mybatisplus.core.metadata.IPage
import com.eliza.spring.library.model.User
import org.apache.ibatis.annotations.Delete
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Select
import org.springframework.stereotype.Repository
import java.io.Serializable

@Repository

interface  UserDao : BaseMapper<User> {
    @Insert("insert into Spring.SprUser(name, age) values (#{name}, #{age})")

    override fun insert(entity: User?): Int {
        TODO("Not yet implemented")
    }

    @Delete("DELETE FROM Spring.SprUser where id=#{id} ")

    override fun deleteById(id: Serializable?): Int {
        TODO("Not yet implemented")
    }

    override fun deleteByMap(columnMap: MutableMap<String, Any>?): Int {
        TODO("Not yet implemented")
    }

    override fun deleteBatchIds(idList: MutableCollection<*>?): Int {
        TODO("Not yet implemented")
    }

    @Select("SELECT t.* FROM Spring.SprUser t where id = #{id} ")

    override fun selectById(id: Serializable?): User {
        TODO("Not yet implemented")
    }

    override fun selectBatchIds(idList: MutableCollection<out Serializable>?): MutableList<User> {
        TODO("Not yet implemented")
    }

    override fun selectByMap(columnMap: MutableMap<String, Any>?): MutableList<User> {
        TODO("Not yet implemented")
    }

    override fun <P : IPage<MutableMap<String, Any>>?> selectMapsPage(page: P, queryWrapper: Wrapper<User>?): P {
        TODO("Not yet implemented")
    }

    override fun <P : IPage<User>?> selectPage(page: P, queryWrapper: Wrapper<User>?): P {
        TODO("Not yet implemented")
    }

    override fun selectObjs(queryWrapper: Wrapper<User>?): MutableList<Any> {
        TODO("Not yet implemented")
    }

    override fun selectMaps(queryWrapper: Wrapper<User>?): MutableList<MutableMap<String, Any>> {
        TODO("Not yet implemented")
    }

    override fun selectList(queryWrapper: Wrapper<User>?): MutableList<User> {
        TODO("Not yet implemented")
    }

    override fun selectCount(queryWrapper: Wrapper<User>?): Long {
        TODO("Not yet implemented")
    }

    override fun update(entity: User?, updateWrapper: Wrapper<User>?): Int {
        TODO("Not yet implemented")
    }

    override fun updateById(entity: User?): Int {
        TODO("Not yet implemented")
    }

    override fun delete(queryWrapper: Wrapper<User>?): Int {
        TODO("Not yet implemented")
    }

    override fun deleteById(entity: User?): Int {
        TODO("Not yet implemented")
    }
}