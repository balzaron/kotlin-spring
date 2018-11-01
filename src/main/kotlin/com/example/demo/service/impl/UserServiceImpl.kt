package com.example.demo.service.impl

import com.example.demo.model.User
import com.example.demo.dao.UserRepo
import com.example.demo.service.IUserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service(value = "userService")
class UserServiceImpl: IUserService {
    @Autowired lateinit var userRepo: UserRepo

    override fun addUser(user: User): User {
        userRepo.save(user)
        return user
    }

    override fun findAll(): MutableIterable<User> {
        return userRepo.findAll()
    }


    override fun findByName(name: String): List<User>{
        return  userRepo.findByName(name)
    }

    override fun findById(id: Long): Optional<User> {
        return userRepo.findById(id)
    }

    override fun updateById(id: Long, name: String, phone: String) {
        userRepo.updateById(name, phone,id)
    }
}