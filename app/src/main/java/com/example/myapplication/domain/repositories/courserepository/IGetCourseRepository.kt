package com.example.myapplication.domain.repositories.courserepository

import com.example.myapplication.domain.models.Course
import com.example.myapplication.domain.models.Student

interface IGetCourseRepository {

    suspend fun getCourses(): List<Course>
}