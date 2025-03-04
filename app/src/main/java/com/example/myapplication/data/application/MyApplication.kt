package com.example.myapplication.data.application

import android.app.Application
import com.example.myapplication.data.databases.roomdatabase.database.AppRoomDatabase
import com.example.myapplication.data.databases.roomdatabase.repositories.UsersRepositoryImpl
import com.example.myapplication.domain.repositories.getUsersRepository

class MyApplication: Application() {

   private val database: AppRoomDatabase by lazy { AppRoomDatabase.getInstance(this) }
   val usersRepositoryImpl: getUsersRepository by lazy { UsersRepositoryImpl(database) }
}