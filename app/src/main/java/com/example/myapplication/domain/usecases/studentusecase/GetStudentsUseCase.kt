package com.example.myapplication.domain.usecases.studentusecase

import com.example.myapplication.domain.models.Student
import com.example.myapplication.domain.repositories.studentrepository.IGetStudentsRepository

class GetStudentsUseCase(private val getStudentsRepository: IGetStudentsRepository) {

    suspend operator fun invoke(): List<Student>{
        return  getStudentsRepository.getStudents()
    }
}