package com.example.myapplication.data.databases.roomdatabase.repositories.courserepository

import com.example.myapplication.data.databases.roomdatabase.database.AppRoomDatabase
import com.example.myapplication.data.databases.roomdatabase.models.CourseDto
import com.example.myapplication.domain.models.Course
import com.example.myapplication.domain.repositories.courserepository.IAddCourseRepository

class AddCourseRepositoryImpl(private val database: AppRoomDatabase) : IAddCourseRepository {

    private val courseDao = database.courseDao()


    override suspend fun addCourse(course: Course) {
        courseDao.insertCourse(CourseDto( coursePicture= course.coursePicture, name = course.name, intro = course.intro, description = course.description))
    }


}