package com.example.myapplication.presentaition.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.domain.models.Course
import com.example.myapplication.presentaition.ui.fragments.registration.MUserProfileFragment
import com.example.myapplication.presentaition.viewmodels.courseviewmodel.AddCourseViewModel


@Composable
fun AddCourseScreen(
    addCourseViewModel: AddCourseViewModel,
    onNextClick: () -> Unit
){

    val name = remember { mutableStateOf("") }
    val intro =  remember { mutableStateOf("") }
    val description =  remember { mutableStateOf("") }

    Column(
        modifier = Modifier.padding(16.dp)
    ){

        OutlinedTextField(
            value = name.value,
            onValueChange = { name.value = it},
            label = { Text(text= "Название Курса") },
            placeholder = { Text(text= "Введите название курса:") },


        )
        OutlinedTextField(
            value = intro.value,
            onValueChange = { intro.value = it},
            label = { Text(text= "Введение в курс") },
            placeholder = { Text(text= "Введите краткое описание курса:") },


        )

        OutlinedTextField(
            value = description.value,
            onValueChange = { description.value = it},
            label = { Text(text= "Описание курса") },
            placeholder = { Text(text= "Введите описание курса:") },

        )

        Button(onClick = {

            if(name.value.isNotEmpty() && intro.value.isNotEmpty() && description.value.isNotEmpty()){

                addCourseViewModel.addCourse(
                    Course(
                    coursePicture = R.drawable.course,
                    name = name.value,
                    intro = intro.value,
                    description = description.value
                )
                )
             // replaceFragment(MUserProfileFragment::class.java.name) // Используем .name для получения полного имени класса
            }


        }){
            Text("Сохранить данные")
        }

        Button(onClick = onNextClick) {
            Text("Перейти в профиль")
        }
    }


}







