package com.example.demo.controller

import com.example.demo.model.User
import com.example.demo.service.IUserService
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/user")
class UserController(val userService: IUserService) {

    @GetMapping("/all")
    fun findAll() =userService.findAll()

    @GetMapping("/{name}")
    fun findbyName(@PathVariable name:String) = userService.findByName(name)

    @PostMapping("/add")
    fun addUser(@Valid @RequestBody user: User): User {
        userService.addUser(user)
        return user
    }

    @PutMapping("/modify/{id}")
    fun updateUser(@PathVariable id:Long, @RequestBody user: User){
        userService.updateById(id, user.name!!, user.phone!!)
    }

}