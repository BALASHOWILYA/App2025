package com.example.myapplication.presentaition.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.domain.states.UserLoginState
import com.example.myapplication.presentaition.ui.fragments.registration.MUserProfileFragment
import com.example.myapplication.presentaition.viewmodels.LogInViewModel


@Composable
fun LoginScreen(
    onNextClick: () -> Unit

){

    val userLoginState: UserLoginState = UserLoginState()


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Text(text= "Вход в аккаунт")
        OutlinedTextField(
            value = userLoginState.phoneNumber,
            label = { Text(text= "Номер телефона")},
            placeholder = { Text(text= "Введите номер телефона:")},
            onValueChange = { }

        )
        OutlinedTextField(
            value = userLoginState.password,
            label = { Text(text= "Пароль")},
            placeholder = { Text(text= "Введите пароль:")},
            onValueChange = { }

        )
        Button(onClick = onNextClick){
            Text("Вход")
        }
    }

}




