package com.example.myapplication.domain.repositories.studentrepository

import com.example.myapplication.domain.models.Student


interface GetStudentsRepository {
    suspend fun getStudents(): List<Student>
}