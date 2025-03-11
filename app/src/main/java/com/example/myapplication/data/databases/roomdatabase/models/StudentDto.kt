package com.example.myapplication.data.databases.roomdatabase.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "students")
data class StudentDto(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val profilePicture: Int,
    val name: String,
    val surname: String,
    val phoneNumber: String,
    val age: Int
)
