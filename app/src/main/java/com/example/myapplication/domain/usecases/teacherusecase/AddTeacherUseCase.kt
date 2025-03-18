package com.example.myapplication.domain.usecases.teacherusecase

import com.example.myapplication.domain.models.Teacher
import com.example.myapplication.domain.repositories.teacherrepository.IAddTeacherRepository

class AddTeacherUseCase(private val addTeacherRepository:  IAddTeacherRepository){

    suspend operator fun invoke(teacher: Teacher){
        addTeacherRepository.addTeacher(teacher)
    }
}