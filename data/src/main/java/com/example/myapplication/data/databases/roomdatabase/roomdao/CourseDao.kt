package com.example.myapplication.data.databases.roomdatabase.roomdao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplication.data.databases.roomdatabase.models.CourseDto


@Dao
interface CourseDao {

    @Query("SELECT * FROM course")
    suspend fun getAllCourses(): List<CourseDto>



    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCourse(userDto: CourseDto)

}