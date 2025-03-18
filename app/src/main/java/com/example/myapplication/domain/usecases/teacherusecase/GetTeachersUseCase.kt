package com.example.myapplication.domain.usecases.teacherusecase

import com.example.myapplication.domain.models.Teacher
import com.example.myapplication.domain.repositories.teacherrepository.IGetTeachersRepository

class GetTeachersUseCase(private val getTeachersRepository: IGetTeachersRepository) {

    suspend operator fun invoke(): List<Teacher>{
        return  getTeachersRepository.getTeachers()
    }
}