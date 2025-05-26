package com.example.myapplication.domain.repositories.userrepository

import com.example.myapplication.domain.models.User

interface ICheckUserRepository {
    suspend fun checkUser(user: com.example.myapplication.domain.models.User): User?
}