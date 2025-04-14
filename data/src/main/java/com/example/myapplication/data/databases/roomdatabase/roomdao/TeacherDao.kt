package com.example.myapplication.data.databases.roomdatabase.roomdao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplication.data.databases.roomdatabase.models.TeacherDto
import com.example.myapplication.data.databases.roomdatabase.models.UserDto

@Dao
interface TeacherDao {

    @Query("SELECT * FROM teachers")
    suspend fun getAllTeaches(): List<TeacherDto>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTeacher(teacherDto: TeacherDto)

}