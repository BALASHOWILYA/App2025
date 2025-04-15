package com.example.myapplication.presentaition.di.appdi

import com.example.myapplication.presentaition.viewmodels.courseviewmodel.AddCourseViewModel
import com.example.myapplication.presentaition.viewmodels.courseviewmodel.GetCourseViewModel
import com.example.myapplication.presentaition.viewmodels.userviewmodel.AddUserViewModel
import com.example.myapplication.presentaition.viewmodels.userviewmodel.UserViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel<AddUserViewModel>{
        AddUserViewModel(
            addUserUseCase = get()
        )
    }

    viewModel<UserViewModel>{
        UserViewModel(
            getUsersUseCase = get()
        )
    }

    viewModel<AddCourseViewModel> {
        AddCourseViewModel(
            addCourseUseCase = get()
        )
    }

    viewModel<GetCourseViewModel>{
        GetCourseViewModel(
            getCoursesUseCase = get()
        )
    }

}