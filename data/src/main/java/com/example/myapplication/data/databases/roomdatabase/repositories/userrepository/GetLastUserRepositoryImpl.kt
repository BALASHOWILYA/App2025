package com.example.myapplication.data.databases.roomdatabase.repositories.userrepository

import android.util.Log
import com.example.myapplication.data.databases.roomdatabase.database.AppRoomDatabase
import com.example.myapplication.domain.models.User
import com.example.myapplication.domain.repositories.userrepository.IGetLastUserRepository

class GetLastUserRepositoryImpl(private val database: AppRoomDatabase): IGetLastUserRepository  {


    private  val userDao = database.userDao()

    override suspend fun getUser(): User? {
        try{
            val userDto = userDao.getUser()
            return User(userDto.username,userDto.password,  userDto.phoneNumber, userDto.profilePhoto, userDto.age)}
        catch (e: Exception){
            Log.d("DBException", e.toString())
            return null
        }
    }


}