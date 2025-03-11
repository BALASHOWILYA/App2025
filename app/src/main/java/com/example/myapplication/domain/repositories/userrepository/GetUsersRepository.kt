package com.example.myapplication.domain.repositories.userrepository

import com.example.myapplication.domain.models.User


interface GetUsersRepository {

    suspend fun getUsers(): List<User>

}