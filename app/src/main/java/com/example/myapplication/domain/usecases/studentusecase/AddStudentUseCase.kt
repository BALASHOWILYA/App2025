package com.example.myapplication.domain.usecases.studentusecase

import com.example.myapplication.domain.models.Student
import com.example.myapplication.domain.models.User
import com.example.myapplication.domain.repositories.studentrepository.AddStudentRepository
import com.example.myapplication.domain.repositories.userrepository.AddUserRepository

class AddStudentUseCase(private val addStudentRepository: AddStudentRepository) {

    suspend operator fun invoke(student: Student){
        addStudentRepository.addStudent(student)
    }
}