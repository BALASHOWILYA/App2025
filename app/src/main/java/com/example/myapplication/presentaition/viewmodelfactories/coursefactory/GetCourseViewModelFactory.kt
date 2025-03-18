package com.example.myapplication.presentaition.viewmodelfactories.coursefactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.domain.usecases.courseusecase.AddCourseUseCase
import com.example.myapplication.domain.usecases.courseusecase.GetCoursesUseCase
import com.example.myapplication.presentaition.viewmodels.courseviewmodel.AddCourseViewModel
import com.example.myapplication.presentaition.viewmodels.courseviewmodel.GetCourseViewModel

@Suppress("UNCHECKED_CAST")
class GetCourseViewModelFactory(private val getCourseUseCase: GetCoursesUseCase) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return GetCourseViewModel(getCourseUseCase) as T
    }
}