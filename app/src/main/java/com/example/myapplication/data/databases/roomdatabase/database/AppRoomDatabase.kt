package com.example.myapplication.data.databases.roomdatabase.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.data.databases.roomdatabase.roomdao.UserDao
import com.example.myapplication.data.databases.roomdatabase.models.UserDto

@Database(entities = [UserDto::class], version = 1)
abstract class AppRoomDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao


    companion object{

        @Volatile
        private var INSTANCE: AppRoomDatabase? = null

        fun getInstance(context: Context): AppRoomDatabase {
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppRoomDatabase::class.java,
                    "app_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }



}