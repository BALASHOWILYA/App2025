package com.example.myapplication.domain.usecases.courseusecase

import com.example.myapplication.domain.models.Course
import com.example.myapplication.domain.models.User
import com.example.myapplication.domain.repositories.courserepository.IAddCourseRepository
import com.example.myapplication.domain.repositories.courserepository.IGetCourseRepository

class GetCoursesUseCase(private val getCourseRepository: IGetCourseRepository) {

    suspend operator fun invoke(): List<Course>{
        return  getCourseRepository.getCourses()
    }
}