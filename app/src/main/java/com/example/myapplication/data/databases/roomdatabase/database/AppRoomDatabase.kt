package com.example.myapplication.data.databases.roomdatabase.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.data.databases.roomdatabase.models.StudentDto
import com.example.myapplication.data.databases.roomdatabase.models.TeacherDto
import com.example.myapplication.data.databases.roomdatabase.roomdao.UserDao
import com.example.myapplication.data.databases.roomdatabase.models.UserDto
import com.example.myapplication.data.databases.roomdatabase.roomdao.StudentDao
import com.example.myapplication.data.databases.roomdatabase.roomdao.TeacherDao

@Database(entities = [UserDto::class, StudentDto::class, TeacherDto::class], version = 3)
abstract class AppRoomDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun teacherDao(): TeacherDao
    abstract fun studentDao(): StudentDao

    companion object{

        @Volatile
        private var INSTANCE: AppRoomDatabase? = null

        fun getInstance(context: Context): AppRoomDatabase {
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppRoomDatabase::class.java,
                    "app_database"
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                instance
            }
        }
    }

}