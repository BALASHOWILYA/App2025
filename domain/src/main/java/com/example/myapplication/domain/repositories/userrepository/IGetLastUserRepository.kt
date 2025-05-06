package com.example.myapplication.domain.repositories.userrepository

import com.example.myapplication.domain.models.User

interface IGetLastUserRepository {
    suspend fun getUser(): User?
}

