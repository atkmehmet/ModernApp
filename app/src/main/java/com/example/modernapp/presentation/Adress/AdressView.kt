package com.example.modernapp.presentation.Adress

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.modernapp.domain.model.Address
import com.example.modernapp.domain.usecase.AdressInsertCase
import com.example.modernapp.domain.usecase.AdressListCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class AdressView @Inject constructor(
    private val adressInsertCase: AdressInsertCase,
    private val adressListCase: AdressListCase
) :ViewModel() {

    val id      by mutableStateOf(0)
    val street  by mutableStateOf("")
    val idUser  by mutableStateOf(0)
    val suite   by mutableStateOf("")
    val city    by mutableStateOf("")
    val zipcode by mutableStateOf("")
    var message by mutableStateOf("")
    var adressList by mutableStateOf(listOf<Address>())

    init {
        viewModelScope.launch {
            adressList = adressListCase()
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
}