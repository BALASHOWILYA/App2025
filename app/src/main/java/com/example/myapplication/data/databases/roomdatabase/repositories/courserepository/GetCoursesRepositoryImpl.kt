package com.example.myapplication.data.databases.roomdatabase.repositories.courserepository

import com.example.myapplication.data.databases.roomdatabase.database.AppRoomDatabase
import com.example.myapplication.domain.models.Course
import com.example.myapplication.domain.repositories.courserepository.IGetCourseRepository

class GetCoursesRepositoryImpl(private val database: AppRoomDatabase): IGetCourseRepository {

    private val courseDao = database.courseDao()

    override suspend fun getCourses(): List<Course> {
        val listCourses = courseDao.getAllCourses()

        return listCourses.map{ dto ->
            Course(
                coursePicture = dto.coursePicture,
                name = dto.name,
                intro = dto.intro,
                description = dto.description
            )
        }
    }
}