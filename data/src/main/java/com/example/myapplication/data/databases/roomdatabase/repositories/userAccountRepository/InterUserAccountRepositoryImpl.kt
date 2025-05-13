package com.example.myapplication.data.databases.roomdatabase.repositories.userAccountRepository

import com.example.myapplication.data.databases.roomdatabase.database.AppRoomDatabase
import com.example.myapplication.domain.models.User
import com.example.myapplication.domain.repositories.authenticationrepository.IInterUserAccountRepository
import com.example.myapplication.domain.states.UserLoginState

class InterUserAccountRepositoryImpl(private val database: AppRoomDatabase): IInterUserAccountRepository {

    private  val userDao = database.userDao()

    override suspend fun interUserAccount(userLoginState: UserLoginState): User? {

        try{
            val listUsers = userDao.getAllUsers()
            val userDto = listUsers.filter { userLogin ->
                userLogin.password == userLoginState.password && userLogin.phoneNumber == userLoginState.phoneNumber
            }[0]
            if( userDto.password != null &&
                userDto.phoneNumber != null &&
                userDto.age != null &&
                userDto.id != null &&
                userDto.username != null)
            {
                return User(userDto.username,userDto.password,  userDto.phoneNumber, userDto.profilePhoto, userDto.age)
            }
            else{
                return null
            }


        }
        catch (_: Exception){
            return null
        }

    }
}