package com.example.myapplication.presentaition.di.datadi

import com.example.myapplication.data.databases.roomdatabase.database.AppRoomDatabase
import com.example.myapplication.data.databases.roomdatabase.repositories.courserepository.AddCourseRepositoryImpl
import com.example.myapplication.data.databases.roomdatabase.repositories.courserepository.GetCoursesRepositoryImpl
import com.example.myapplication.data.databases.roomdatabase.repositories.studentrepository.AddStudentRepositoryImpl
import com.example.myapplication.data.databases.roomdatabase.repositories.studentrepository.GetStudentsRepositoryImpl
import com.example.myapplication.data.databases.roomdatabase.repositories.teacherrepository.AddTeacherRepositoryImpl
import com.example.myapplication.data.databases.roomdatabase.repositories.teacherrepository.GetTeachersRepositoryImpl
import com.example.myapplication.data.databases.roomdatabase.repositories.userrepository.AddUserRepositoryImpl
import com.example.myapplication.data.databases.roomdatabase.repositories.userrepository.GetUsersRepositoryImpl
import com.example.myapplication.domain.repositories.courserepository.IAddCourseRepository
import com.example.myapplication.domain.repositories.courserepository.IGetCourseRepository
import com.example.myapplication.domain.repositories.studentrepository.IAddStudentRepository
import com.example.myapplication.domain.repositories.studentrepository.IGetStudentsRepository
import com.example.myapplication.domain.repositories.teacherrepository.IAddTeacherRepository
import com.example.myapplication.domain.repositories.teacherrepository.IGetTeachersRepository
import com.example.myapplication.domain.repositories.userrepository.IAddUserRepository
import com.example.myapplication.domain.repositories.userrepository.IGetUsersRepository
import com.example.myapplication.domain.usecases.userusecase.AddUserUseCase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


val dataModule = module {

    single<AppRoomDatabase> {
        AppRoomDatabase.getInstance(context = get())
    }

    single<IGetUsersRepository> {
        GetUsersRepositoryImpl(database = get())
    }

    single<IAddUserRepository> {
        AddUserRepositoryImpl(database = get())
    }

    single<IGetCourseRepository> {
        GetCoursesRepositoryImpl(database = get())
    }

    single<IAddCourseRepository> {
        AddCourseRepositoryImpl(database = get())
    }

    single< IAddStudentRepository> {
        AddStudentRepositoryImpl(database = get())
    }

    single< IGetStudentsRepository> {
        GetStudentsRepositoryImpl(database = get())
    }

    single<IGetTeachersRepository>{
        GetTeachersRepositoryImpl(database = get())
    }

    single<IAddTeacherRepository>{
        AddTeacherRepositoryImpl(database = get())
    }
}