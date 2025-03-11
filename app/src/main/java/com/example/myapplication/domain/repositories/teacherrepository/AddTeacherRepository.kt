package com.example.myapplication.domain.repositories.teacherrepository

import com.example.myapplication.domain.models.Teacher
import com.example.myapplication.domain.models.User

interface AddTeacherRepository {
    suspend fun addTeacher(teacher: Teacher)
}