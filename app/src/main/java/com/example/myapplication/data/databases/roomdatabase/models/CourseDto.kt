package com.example.myapplication.data.databases.roomdatabase.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "course")
data class CourseDto(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val coursePicture: Int,
    val name: String,
    val intro: String,
    val description: String

)
