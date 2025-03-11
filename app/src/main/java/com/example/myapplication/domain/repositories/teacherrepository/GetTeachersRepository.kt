package com.example.myapplication.domain.repositories.teacherrepository

import com.example.myapplication.domain.models.Teacher
import com.example.myapplication.domain.models.User

interface GetTeachersRepository {
    suspend fun getTeachers(): List<Teacher>
}