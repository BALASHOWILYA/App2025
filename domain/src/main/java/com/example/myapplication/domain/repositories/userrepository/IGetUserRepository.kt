package com.example.myapplication.domain.repositories.userrepository

import com.example.myapplication.domain.models.User

interface IGetUserRepository {
    suspend fun getUser(): User
}