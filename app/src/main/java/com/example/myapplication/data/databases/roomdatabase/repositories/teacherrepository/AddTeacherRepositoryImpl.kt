package com.example.myapplication.data.databases.roomdatabase.repositories.teacherrepository

import com.example.myapplication.data.databases.roomdatabase.database.AppRoomDatabase
import com.example.myapplication.domain.models.Teacher
import com.example.myapplication.domain.repositories.teacherrepository.IAddTeacherRepository

class AddTeacherRepositoryImpl(private val database: AppRoomDatabase): IAddTeacherRepository{
    private  val teacherDao = database.teacherDao()

    override suspend fun addTeacher(teacher: Teacher) {
        TODO("Not yet implemented")
    }
}