package com.example.myapplication.data.databases.roomdatabase.repositories.userrepository

import com.example.myapplication.data.databases.roomdatabase.database.AppRoomDatabase
import com.example.myapplication.domain.models.User
import com.example.myapplication.domain.repositories.userrepository.IGetLastUserRepository

class GetLastUserRepositoryImpl(private val database: AppRoomDatabase): IGetLastUserRepository  {


    private  val userDao = database.userDao()

    override suspend fun getUser(): User {
        val lastUserDto = userDao.getUser()

        return User(username = lastUserDto.username,
            password =  lastUserDto.password,
            phoneNumber = lastUserDto.phoneNumber,
            age=lastUserDto.age)
    }


}