package com.example.modernapp.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Adress")
data  class AdressEntity (
    @PrimaryKey(autoGenerate = true) val id: Int =0,
    val street: String,
    val idUser:Int,
    val suite: String,
    val city: String,
    val zipcode: String

)