package com.example.myapplication.data.databases.roomdatabase.repositories.userrepository

import android.util.Log
import com.example.myapplication.data.databases.roomdatabase.database.AppRoomDatabase
import com.example.myapplication.data.databases.roomdatabase.models.UserDto
import com.example.myapplication.domain.models.User
import com.example.myapplication.domain.repositories.userrepository.ICheckUserRepository

class CheckUserRepositoryImpl(private val database: AppRoomDatabase): ICheckUserRepository {

    private val userDao = database.userDao()

    override suspend fun checkUser(user: User): User? {

        try {
            val password: String = user.password
            val phoneNumber: String = user.phoneNumber
            val userDto: UserDto? = userDao.findUserByPhoneNumberAndPassword(
                phoneNumber = phoneNumber,
                password = password
            )
            if(phoneNumber == user!!.phoneNumber && password == user!!.password ){
                return User(userDto!!.username,userDto.password,  userDto.phoneNumber, userDto.profilePhoto, userDto.age)
            }else{
                return null
            }



        }catch (e: Exception){
            Log.d("CheckAccount", e.toString())
            return null
        }

    }
}





