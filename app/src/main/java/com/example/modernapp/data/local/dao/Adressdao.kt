package com.example.modernapp.data.local.dao

import com.example.modernapp.data.local.entities.AdressEntity

@Dao
interface    Adressdao {

    @insert(OnConflict = OnConflictStrategy.REPLACE)
    suspend fun addAdress(adressEntity: AdressEntity)

    @Query("Select * from Adress")
    suspend fun getAdress():List<AdressEntity>

    @Query("Delete from  Adress  Where id= :id")
    suspend fun  deleteAdress(id:Int)
}