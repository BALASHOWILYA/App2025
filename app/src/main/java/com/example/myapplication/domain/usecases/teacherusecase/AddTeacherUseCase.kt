package com.example.myapplication.domain.usecases.teacherusecase

import com.example.myapplication.domain.models.Teacher
import com.example.myapplication.domain.models.User
import com.example.myapplication.domain.repositories.studentrepository.AddStudentRepository
import com.example.myapplication.domain.repositories.teacherrepository.AddTeacherRepository

class AddTeacherUseCase(private val addTeacherRepository:  AddTeacherRepository){

    suspend operator fun invoke(teacher: Teacher){
        addTeacherRepository.addTeacher(teacher)
    }
}