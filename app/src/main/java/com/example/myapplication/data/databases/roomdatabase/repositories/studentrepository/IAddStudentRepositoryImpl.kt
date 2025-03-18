package com.example.myapplication.data.databases.roomdatabase.repositories.studentrepository

import com.example.myapplication.data.databases.roomdatabase.database.AppRoomDatabase
import com.example.myapplication.domain.models.Student
import com.example.myapplication.domain.repositories.studentrepository.IAddStudentRepository

class IAddStudentRepositoryImpl(private val database: AppRoomDatabase): IAddStudentRepository {
    private val studentDao = database.studentDao()
    override suspend fun addStudent(student: Student) {
        TODO("Not yet implemented")
    }
}