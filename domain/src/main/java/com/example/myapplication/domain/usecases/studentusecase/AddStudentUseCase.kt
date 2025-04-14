package com.example.myapplication.domain.usecases.studentusecase

import com.example.myapplication.domain.models.Student
import com.example.myapplication.domain.repositories.studentrepository.IAddStudentRepository

class AddStudentUseCase(private val addStudentRepository: com.example.myapplication.domain.repositories.studentrepository.IAddStudentRepository) {

    suspend operator fun invoke(student: com.example.myapplication.domain.models.Student){
        addStudentRepository.addStudent(student)
    }
}