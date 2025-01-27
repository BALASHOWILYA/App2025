package com.example.myapplication.domain.repositories

import com.example.myapplication.domain.models.User


interface UserRepository {

    fun getUsers(): List<User>

}