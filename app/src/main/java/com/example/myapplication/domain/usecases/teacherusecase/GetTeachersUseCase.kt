package com.example.myapplication.domain.usecases.teacherusecase

import com.example.myapplication.domain.models.Student
import com.example.myapplication.domain.models.Teacher
import com.example.myapplication.domain.repositories.studentrepository.GetStudentsRepository
import com.example.myapplication.domain.repositories.teacherrepository.GetTeachersRepository

class GetTeachersUseCase(private val getTeachersRepository: GetTeachersRepository) {

    suspend operator fun invoke(): List<Teacher>{
        return  getTeachersRepository.getTeachers()
    }
}