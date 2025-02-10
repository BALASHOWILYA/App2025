package com.example.myapplication.domain.repositories

import com.example.myapplication.domain.models.User

interface addUserRepository {
    suspend fun addUser(user: User)
}