package com.example.myapplication.domain.usecases.courseusecase

import com.example.myapplication.domain.models.Course
import com.example.myapplication.domain.models.User
import com.example.myapplication.domain.repositories.courserepository.IAddCourseRepository
import com.example.myapplication.domain.repositories.userrepository.IAddUserRepository

class AddCourseUseCase(private val addCourseRepository: com.example.myapplication.domain.repositories.courserepository.IAddCourseRepository) {

    suspend operator fun invoke(course: com.example.myapplication.domain.models.Course){
        addCourseRepository.addCourse(course)

    }
}