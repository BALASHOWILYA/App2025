package com.example.myapplication.data.application

import android.app.Application
import com.example.myapplication.data.databases.roomdatabase.database.AppRoomDatabase
import com.example.myapplication.data.databases.roomdatabase.repositories.userrepository.IAddUserRepositoryImpl
import com.example.myapplication.data.databases.roomdatabase.repositories.userrepository.IGetUsersRepositoryImpl
import com.example.myapplication.domain.repositories.userrepository.IAddUserRepository
import com.example.myapplication.domain.repositories.userrepository.IGetUsersRepository

class MyApplication: Application() {

   private val database: AppRoomDatabase by lazy { AppRoomDatabase.getInstance(this) }
   val IGetUsersRepositoryImpl: IGetUsersRepository by lazy { IGetUsersRepositoryImpl(database) }
   val IAddUserRepositoryImpl: IAddUserRepository by lazy { IAddUserRepositoryImpl(database) }
}