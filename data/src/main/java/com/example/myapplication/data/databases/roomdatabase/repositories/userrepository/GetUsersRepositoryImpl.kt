package com.example.myapplication.data.databases.roomdatabase.repositories.userrepository

import com.example.myapplication.data.databases.roomdatabase.database.AppRoomDatabase

import com.example.myapplication.domain.models.User
import com.example.myapplication.domain.repositories.userrepository.IGetUsersRepository

class GetUsersRepositoryImpl(private val database: AppRoomDatabase):
    com.example.myapplication.domain.repositories.userrepository.IGetUsersRepository {

    private  val userDao = database.userDao()


    override suspend fun getUsers(): List<com.example.myapplication.domain.models.User> {
        val listUsers = userDao.getAllUsers()

        return listUsers.map{ dto ->
            com.example.myapplication.domain.models.User(
                username = dto.username,
                password = dto.password,
                age = dto.age,
                phoneNumber = dto.phoneNumber
            )
        }
    }



}