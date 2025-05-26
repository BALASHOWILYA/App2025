package com.example.myapplication.domain.models

data class User(  val username: String = "",
                  val password: String,
                  val phoneNumber: String,
                  val profilePhoto: Int = 0,
                  val age: Int = 0)
