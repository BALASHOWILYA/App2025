package com.example.myapplication.domain.repositories.teacherrepository

import com.example.myapplication.domain.models.Teacher

interface IGetTeachersRepository {
    suspend fun getTeachers(): List<Teacher>
}