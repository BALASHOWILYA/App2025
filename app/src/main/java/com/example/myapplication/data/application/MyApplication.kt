package com.example.myapplication.data.application

import android.app.Application
import com.example.myapplication.data.databases.roomdatabase.database.AppRoomDatabase
import com.example.myapplication.data.databases.roomdatabase.repositories.courserepository.AddCourseRepositoryImpl
import com.example.myapplication.data.databases.roomdatabase.repositories.courserepository.GetCoursesRepositoryImpl
import com.example.myapplication.data.databases.roomdatabase.repositories.userrepository.AddUserRepositoryImpl
import com.example.myapplication.data.databases.roomdatabase.repositories.userrepository.GetUsersRepositoryImpl
import com.example.myapplication.domain.repositories.courserepository.IAddCourseRepository
import com.example.myapplication.domain.repositories.courserepository.IGetCourseRepository
import com.example.myapplication.domain.repositories.userrepository.IAddUserRepository
import com.example.myapplication.domain.repositories.userrepository.IGetUsersRepository

class MyApplication: Application() {

   private val database: AppRoomDatabase by lazy { AppRoomDatabase.getInstance(this) }
   val getUsersRepositoryImpl: IGetUsersRepository by lazy { GetUsersRepositoryImpl(database) }
   val addUserRepositoryImpl: IAddUserRepository by lazy { AddUserRepositoryImpl(database) }
   val getCoursesRepositoryImpl: IGetCourseRepository by lazy{ GetCoursesRepositoryImpl(database) }
   val addCourseRepositoryImpl: IAddCourseRepository by lazy{ AddCourseRepositoryImpl(database)}
}