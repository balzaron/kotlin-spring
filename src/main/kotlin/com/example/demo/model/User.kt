package com.example.demo.model

import javax.persistence.*

@Entity
@Table(name ="user")
data class User(@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
                val id: Long? ,
                val name:String? = "",
                val phone:String? ="")