package com.example.demo.dao

import com.example.demo.model.User
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.transaction.annotation.Transactional

interface UserRepo:CrudRepository<User, Long> {
    @Query("select * from user m where m.name=:name", nativeQuery = true)
    fun findByName(@Param("name") name: String):List<User>

    @Modifying
    @Query("update user m set m.name=:name,m.phone=:phone where m.id=:id", nativeQuery = true)
    @Transactional()
    fun updateById(@Param("name") name: String, @Param("phone") phone: String, @Param("id") id: Long)
}