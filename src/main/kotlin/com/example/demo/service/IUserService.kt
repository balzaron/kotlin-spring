package com.example.demo.service

import com.example.demo.model.User
import java.util.*

interface IUserService {
    fun updateById(id: Long, name: String, phone: String)
    fun findByName(name: String): List<User>
    fun findById(id: Long): Optional<User>
    fun findAll(): MutableIterable<User>
    fun addUser(user: User): User
}