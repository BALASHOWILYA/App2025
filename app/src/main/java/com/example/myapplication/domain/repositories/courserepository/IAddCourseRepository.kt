package com.example.myapplication.domain.repositories.courserepository

import com.example.myapplication.domain.models.Course
import com.example.myapplication.domain.models.Student

interface IAddCourseRepository {
    suspend fun addCourse(course: Course)
}