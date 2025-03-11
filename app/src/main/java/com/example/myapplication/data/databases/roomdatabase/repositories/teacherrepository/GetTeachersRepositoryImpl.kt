package com.example.myapplication.data.databases.roomdatabase.repositories.teacherrepository

import com.example.myapplication.data.databases.roomdatabase.database.AppRoomDatabase
import com.example.myapplication.domain.models.Teacher
import com.example.myapplication.domain.models.User
import com.example.myapplication.domain.repositories.teacherrepository.GetTeachersRepository

class GetTeachersRepositoryImpl(private val database: AppRoomDatabase): GetTeachersRepository{

    private  val teacherDao = database.teacherDao()


    override suspend fun getTeachers(): List<Teacher> {
        val listUsers = teacherDao.getAllTeaches()

        return listUsers.map{ dto ->
            Teacher(
                name = dto.name,
                profilePicture = dto.profilePicture,
                surname = dto.surname,
                phoneNumber = dto.phoneNumber,
                age = dto.age
            )
        }
    }


}