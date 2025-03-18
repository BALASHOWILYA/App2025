package com.example.myapplication.domain.usecases.courseusecase

import com.example.myapplication.domain.models.Course
import com.example.myapplication.domain.models.User
import com.example.myapplication.domain.repositories.courserepository.IAddCourseRepository
import com.example.myapplication.domain.repositories.userrepository.IAddUserRepository

class AddCourseUseCase(private val addCourseRepository: IAddCourseRepository) {

    suspend operator fun invoke(course: Course){
        addCourseRepository.addCourse(course)
    }
}