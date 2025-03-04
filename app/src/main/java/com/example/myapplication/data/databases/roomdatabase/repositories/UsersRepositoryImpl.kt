package com.example.myapplication.data.databases.roomdatabase.repositories

import android.util.Log
import com.example.myapplication.data.databases.roomdatabase.database.AppRoomDatabase
import com.example.myapplication.data.databases.roomdatabase.models.UserDto

import com.example.myapplication.domain.models.User
import com.example.myapplication.domain.repositories.getUsersRepository
import com.example.myapplication.domain.repositories.addUserRepository

class UsersRepositoryImpl(private val database: AppRoomDatabase): getUsersRepository, addUserRepository {

    private  val userDao = database.userDao()


    override suspend fun getUsers(): List<User> {
        val listUsers = userDao.getAllUsers()

        return listUsers.map{ dto ->
            User(
                username = dto.username,
                password = dto.password,
                age = dto.age,
                phoneNumber = dto.phoneNumber
            )
        }
    }

    override suspend fun addUser(user: User) {
        userDao.insertUser(UserDto(username = user.username, password = user.password, age = user.age, phoneNumber = user.phoneNumber))
        Log.d("add","added successful")
    }


}