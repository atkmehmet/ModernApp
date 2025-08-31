package com.example.modernapp.presentation.Adress

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.modernapp.domain.model.Address
import com.example.modernapp.domain.repository.AdressRepository
import com.example.modernapp.domain.usecase.AdressInsertCase
import com.example.modernapp.domain.usecase.AdressListCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AdressView @Inject constructor(
    private val adressInsertCase: AdressInsertCase,
    private val adressListCase: AdressListCase,
    private val adressRepository: AdressRepository
) :ViewModel() {

    var id      by mutableStateOf(0)
    var street  by mutableStateOf("")
    var idUser  by mutableStateOf(0)
    var suite   by mutableStateOf("")
    var city    by mutableStateOf("")
    var zipcode by mutableStateOf("")
    var message by mutableStateOf("")
    var adressList by mutableStateOf(listOf<Address>())

    init {
        viewModelScope.launch {
            adressRepository.insertToApi()
            adressList = adressListCase()

        }
    }
        fun InsertAdress(){
            viewModelScope.launch {
                try {

                    adressInsertCase(Address(
                        id = 0,
                        street = street,
                        idUser = idUser,
                        suite = suite,
                        city = city,
                        zipcode = zipcode
                    ))

                }
                catch (ex:Exception){
                           message = ex.toString()
                }

            }
        }



    }
