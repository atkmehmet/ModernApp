package com.example.modernapp.domain.repository

import com.example.modernapp.domain.model.Address

interface AdressRepository {

    suspend fun insertAdress(adress:Address)

    suspend fun getAdresses():List<Address>

    suspend fun deleteAdress(id:Int)

    suspend fun insertToApi()

}