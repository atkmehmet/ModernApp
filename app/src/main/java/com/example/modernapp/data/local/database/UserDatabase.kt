package com.example.modernapp.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.modernapp.data.local.dao.UserDao
import com.example.modernapp.data.local.entities.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}

