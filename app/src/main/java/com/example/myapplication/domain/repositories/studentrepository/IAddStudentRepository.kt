package com.example.myapplication.domain.repositories.studentrepository

import com.example.myapplication.domain.models.Student


interface IAddStudentRepository {
    suspend fun addStudent(student: Student)
}