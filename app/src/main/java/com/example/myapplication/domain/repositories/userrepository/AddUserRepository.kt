package com.example.myapplication.domain.repositories.userrepository

import com.example.myapplication.domain.models.User

interface AddUserRepository {
    suspend fun addUser(user: User)
}