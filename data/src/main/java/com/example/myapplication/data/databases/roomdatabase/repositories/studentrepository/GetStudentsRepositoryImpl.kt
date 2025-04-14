package com.example.myapplication.data.databases.roomdatabase.repositories.studentrepository

import com.example.myapplication.data.databases.roomdatabase.database.AppRoomDatabase
import com.example.myapplication.domain.models.Student
import com.example.myapplication.domain.repositories.studentrepository.IGetStudentsRepository

class GetStudentsRepositoryImpl(private val database: AppRoomDatabase):
    com.example.myapplication.domain.repositories.studentrepository.IGetStudentsRepository {
    private val studentDao = database.studentDao()
    override suspend fun getStudents(): List<com.example.myapplication.domain.models.Student> {
        TODO("Not yet implemented")
    }

}