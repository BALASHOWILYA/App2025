package com.example.myapplication.data.application

import android.app.Application
import com.example.myapplication.data.databases.roomdatabase.database.AppRoomDatabase
import com.example.myapplication.data.databases.roomdatabase.repositories.userrepository.AddUserRepositoryImpl
import com.example.myapplication.data.databases.roomdatabase.repositories.userrepository.GetUsersRepositoryImpl
import com.example.myapplication.domain.repositories.addUserRepository
import com.example.myapplication.domain.repositories.getUsersRepository

class MyApplication: Application() {

   private val database: AppRoomDatabase by lazy { AppRoomDatabase.getInstance(this) }
   val getUsersRepositoryImpl: getUsersRepository  by lazy { GetUsersRepositoryImpl(database) }
   val addUserRepositoryImpl: addUserRepository by lazy { AddUserRepositoryImpl(database) }
}