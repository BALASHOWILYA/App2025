package com.example.myapplication.presentaition.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.myapplication.domain.models.User
import com.example.myapplication.presentaition.viewmodels.userviewmodel.CheckUserViewModel


@Composable
fun LoginScreen(
    checkUserViewModel: CheckUserViewModel,
    onNextClick: () -> Unit

){

    val phoneNumber = remember { mutableStateOf("") }
    val password =  remember { mutableStateOf("") }


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Text(text= "Вход в аккаунт")
        OutlinedTextField(
            value = phoneNumber.value,
            label = { Text(text= "Номер телефона")},
            placeholder = { Text(text= "Введите номер телефона:")},
            onValueChange = { phoneNumber.value = it }

        )
        OutlinedTextField(
            value = password.value,
            label = { Text(text= "Пароль")},
            placeholder = { Text(text= "Введите пароль:")},
            onValueChange = { password.value = it }

        )
        Button(onClick = {

            if(phoneNumber.value.isNotEmpty() && password.value.isNotEmpty()){

                checkUserViewModel.checkUser(
                    User(
                        phoneNumber = phoneNumber.value,
                        password = password.value
                    )
                )
            }


        }){
            Text("Сохранить данные")
        }
        Button(onClick = onNextClick){
            Text("Вход")
        }
    }

}




