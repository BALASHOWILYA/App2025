package com.example.myapplication.domain.repositories.userrepository

import com.example.myapplication.domain.models.User

interface IAddUserRepository {
    suspend fun addUser(user: User)
}