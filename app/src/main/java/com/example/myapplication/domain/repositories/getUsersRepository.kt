package com.example.myapplication.domain.repositories

import com.example.myapplication.domain.models.User


interface getUsersRepository {

    suspend fun getUsers(): List<User>

}