package com.example.myapplication.data.databases.roomdatabase.roomdao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplication.data.databases.roomdatabase.models.StudentDto
import com.example.myapplication.data.databases.roomdatabase.models.TeacherDto
import com.example.myapplication.data.databases.roomdatabase.models.UserDto


@Dao
interface StudentDao {

    @Query("SELECT * FROM teachers")
    suspend fun getAllStudents(): List<StudentDto>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(studentDto: StudentDto)
}