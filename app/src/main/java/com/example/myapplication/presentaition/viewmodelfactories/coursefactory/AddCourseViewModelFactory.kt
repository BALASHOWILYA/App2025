package com.example.myapplication.presentaition.viewmodelfactories.coursefactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.domain.usecases.courseusecase.AddCourseUseCase
import com.example.myapplication.presentaition.viewmodels.courseviewmodel.AddCourseViewModel



@Suppress("UNCHECKED_CAST")
class AddCourseViewModelFactory(private val addCourseUseCase: AddCourseUseCase) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AddCourseViewModel(addCourseUseCase) as T
    }
}