package com.example.myapplication.presentaition.di.domaindi

import com.example.myapplication.domain.repositories.userrepository.IAddUserRepository
import com.example.myapplication.domain.usecases.authenticationusecase.InterUserAccountUseCase
import com.example.myapplication.domain.usecases.courseusecase.AddCourseUseCase
import com.example.myapplication.domain.usecases.courseusecase.GetCoursesUseCase
import com.example.myapplication.domain.usecases.studentusecase.AddStudentUseCase
import com.example.myapplication.domain.usecases.studentusecase.GetStudentsUseCase
import com.example.myapplication.domain.usecases.teacherusecase.AddTeacherUseCase
import com.example.myapplication.domain.usecases.teacherusecase.GetTeachersUseCase
import com.example.myapplication.domain.usecases.userusecase.AddUserUseCase
import com.example.myapplication.domain.usecases.userusecase.CheckUserUseCase
import com.example.myapplication.domain.usecases.userusecase.GetUserUseCase
import com.example.myapplication.domain.usecases.userusecase.GetUsersUseCase
import org.koin.dsl.factory
import org.koin.dsl.module

val domainModule = module {

    factory<AddUserUseCase>{
        AddUserUseCase(addUserRepository = get())
    }

    factory<GetUsersUseCase>{
        GetUsersUseCase(getUsersRepository = get())
    }

    factory<GetUserUseCase> {
        GetUserUseCase(getLastUserRepository = get())
    }

    factory<CheckUserUseCase> {
        CheckUserUseCase(checkUserRepository = get())
    }

    factory<InterUserAccountUseCase> {
        InterUserAccountUseCase(interUserAccountRepository = get())
    }

    factory<GetTeachersUseCase>{
        GetTeachersUseCase(getTeachersRepository = get())
    }

    factory<AddTeacherUseCase>{
        AddTeacherUseCase(addTeacherRepository = get())
    }

    factory<GetStudentsUseCase>{
        GetStudentsUseCase(getStudentsRepository = get())
    }

    factory<AddStudentUseCase>{
        AddStudentUseCase(addStudentRepository = get())
    }

    factory<GetCoursesUseCase>{
        GetCoursesUseCase(getCourseRepository = get())
    }

    factory<AddCourseUseCase>{
        AddCourseUseCase(addCourseRepository = get())
    }












}