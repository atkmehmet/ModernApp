package com.example.modernapp.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.modernapp.data.local.dao.Adressdao
import com.example.modernapp.data.local.dao.UserDao
import com.example.modernapp.data.local.entities.AdressEntity
import com.example.modernapp.data.local.entities.UserEntity

@Database( entities =  [AdressEntity::class,UserEntity::class],version = 1)
abstract class  Database: RoomDatabase() {
    abstract fun userDao():UserDao
    abstract fun adressDao():Adressdao

}