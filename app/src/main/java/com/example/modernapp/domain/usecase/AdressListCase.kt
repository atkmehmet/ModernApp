package com.example.modernapp.domain.usecase

import com.example.modernapp.domain.model.Address
import com.example.modernapp.domain.repository.AdressRepository

class AdressListCase(
    private val repository: AdressRepository
) {

    suspend operator fun invoke(): List<Address> {
      return  repository.getAdresses()
    }
}