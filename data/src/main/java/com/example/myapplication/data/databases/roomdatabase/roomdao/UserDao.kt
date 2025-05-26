package com.example.myapplication.data.databases.roomdatabase.roomdao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplication.data.databases.roomdatabase.models.UserDto
import com.example.myapplication.domain.models.User


@Dao
interface UserDao {

    @Query("SELECT * FROM users")
    suspend fun getAllUsers(): List<UserDto>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(userDto: UserDto)

    @Query("SELECT * FROM users WHERE  id =(SELECT MAX(id) FROM users)")
    suspend fun getUser(): UserDto

    @Query("SELECT * FROM users WHERE phoneNumber = :phoneNumber AND password = :password")
    fun findUserByPhoneNumberAndPassword(
        phoneNumber: String,
        password: String
    ): UserDto?






}