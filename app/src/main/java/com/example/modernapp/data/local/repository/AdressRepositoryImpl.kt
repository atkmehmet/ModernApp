package com.example.modernapp.data.local.repository

import com.example.modernapp.data.local.dao.Adressdao
import com.example.modernapp.data.local.entities.AdressEntity
import com.example.modernapp.data.remote.service.UserApiService
import com.example.modernapp.domain.model.Address
import com.example.modernapp.domain.repository.AdressRepository

class AdressRepositoryImpl(
    private val adressdao: Adressdao,
    private val userApiService: UserApiService
):AdressRepository {
    override suspend fun insertAdress(adress: Address) {
        adressdao.addAdress(AdressEntity(
            street = adress.street,
            suite = adress.suite,
            city = adress.city,
            zipcode = adress.zipcode,
            idUser = adress.idUser
        ))
    }

    override suspend fun getAdresses(): List<Address> {
      val adresses =  adressdao.getAdress()
      return  adresses.map { adres->
            Address(
                street = adres.street,
                suite = adres.suite,
                city = adres.city,
                zipcode = adres.zipcode,
                idUser = adres.idUser,
                id = adres.id
            )

        }

    }

    override suspend fun deleteAdress(id: Int) {
      adressdao.deleteAdress(id)
    }

    override suspend fun insertToApi() {
        val users = userApiService.getUsers()
        users.forEach {
            val address = AdressEntity(
                street = it.address.street,
                suite = it.address.suite,
                zipcode = it.address.zipcode,
                city = it.address.city,
                idUser = 1
            )
            adressdao.addAdress(address)
        }
    }
}