package com.example.myapplication.presentaition.ui.screens

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.example.myapplication.presentaition.viewmodels.FirstState


@Composable
fun LoginScreen(
    state: FirstState,
    onNextClick: () -> Unit
){
    Text(text= "Вход в аккаунт")
    Button(onClick = onNextClick){
        Text("Вход")
    }
}