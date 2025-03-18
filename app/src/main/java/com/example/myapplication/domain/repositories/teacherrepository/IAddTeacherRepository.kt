package com.example.myapplication.domain.repositories.teacherrepository

import com.example.myapplication.domain.models.Teacher

interface IAddTeacherRepository {
    suspend fun addTeacher(teacher: Teacher)
}