package com.example.myapplication.data.databases.roomdatabase.repositories.userrepository

import android.util.Log
import com.example.myapplication.data.databases.roomdatabase.database.AppRoomDatabase
import com.example.myapplication.data.databases.roomdatabase.models.UserDto
import com.example.myapplication.domain.models.User
import com.example.myapplication.domain.repositories.userrepository.IAddUserRepository

class AddUserRepositoryImpl(private val database: AppRoomDatabase): IAddUserRepository {

    private  val userDao = database.userDao()

    override suspend fun addUser(user: User) {
        userDao.insertUser(UserDto(username = user.username, password = user.password, age = user.age, phoneNumber = user.phoneNumber))
        Log.d("add","added successful")
    }

}