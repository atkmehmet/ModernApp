package com.example.modernapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.modernapp.data.local.entities.AdressEntity

@Dao
interface    Adressdao {

    @Insert
    suspend fun addAdress(adressEntity: AdressEntity)

    @Query("Select * from Adress")
    suspend fun getAdress():List<AdressEntity>

    @Query("Delete from  Adress  Where id= :id")
    suspend fun  deleteAdress(id:Int)
}