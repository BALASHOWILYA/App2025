package com.example.myapplication.data.databases.roomdatabase.repositories.studentrepository

import com.example.myapplication.data.databases.roomdatabase.database.AppRoomDatabase
import com.example.myapplication.domain.models.Student
import com.example.myapplication.domain.repositories.studentrepository.GetStudentsRepository

class GetStudentsRepositoryImpl(private val database: AppRoomDatabase): GetStudentsRepository {
    private val studentDao = database.studentDao()
    override suspend fun getStudents(): List<Student> {
        TODO("Not yet implemented")
    }

}