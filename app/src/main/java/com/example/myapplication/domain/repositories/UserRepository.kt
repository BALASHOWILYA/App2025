package com.example.myapplication.domain.repositories

import com.example.myapplication.domain.models.User


interface UserRepository {

    suspend fun getUsers(): List<User>

}