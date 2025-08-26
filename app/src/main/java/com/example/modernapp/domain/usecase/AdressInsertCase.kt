package com.example.modernapp.domain.usecase

import com.example.modernapp.domain.model.Address
import com.example.modernapp.domain.repository.AdressRepository

class AdressInsertCase(
    private val adressRepository: AdressRepository
) {
    suspend operator fun invoke(adress:Address){
        adressRepository.insertAdress(adress)
    }
}