package com.example.myapplication.data.application

import android.app.Application
import com.example.myapplication.data.databases.roomdatabase.database.AppRoomDatabase
import com.example.myapplication.data.databases.roomdatabase.repositories.userrepository.AddUserRepositoryImpl
import com.example.myapplication.data.databases.roomdatabase.repositories.userrepository.GetUsersRepositoryImpl
import com.example.myapplication.domain.repositories.userrepository.AddUserRepository
import com.example.myapplication.domain.repositories.userrepository.GetUsersRepository

class MyApplication: Application() {

   private val database: AppRoomDatabase by lazy { AppRoomDatabase.getInstance(this) }
   val getUsersRepositoryImpl: GetUsersRepository by lazy { GetUsersRepositoryImpl(database) }
   val addUserRepositoryImpl: AddUserRepository by lazy { AddUserRepositoryImpl(database) }
}