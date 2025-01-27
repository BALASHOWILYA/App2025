package com.example.myapplication.data.repositories

import com.example.myapplication.data.models.UserDto
import com.example.myapplication.domain.models.User
import com.example.myapplication.domain.repositories.UserRepository

class UserRepositoryImpl: UserRepository {



    override fun getUsers(): List<User> {
        val userDtos = listOf(
            UserDto(1, "Harry", "Potter", 13),
            UserDto(2, "Sirius", "Black", 33),
        )

        return userDtos.map{ dto ->
            User(
                name = dto.name,
                surname = dto.surname,
                age = dto.age
            )

        }
    }
}