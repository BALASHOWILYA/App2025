package com.example.myapplication.data.repositories

import com.example.myapplication.data.models.UserDto
import com.example.myapplication.domain.models.User
import com.example.myapplication.domain.repositories.getUsersRepository
import com.example.myapplication.domain.repositories.addUserRepository

class getUsersRepositoryImpl: getUsersRepository, addUserRepository {
    val listUsers = mutableListOf(
        UserDto(1, "Harry", "Potter", 13),
        UserDto(2, "Sirius", "Black", 33),
    )



    override suspend fun getUsers(): List<User> {

        return listUsers.map{ dto ->
            User(
                name = dto.name,
                surname = dto.surname,
                age = dto.age
            )

        }
    }

    override suspend fun addUser(user: User) {
        listUsers.add(UserDto(id=3, name = user.name, surname = user.surname, age = user.age))
    }
}