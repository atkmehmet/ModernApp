package com.example.modernapp.presentation.Adress

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun AdressScreen(
    adressView: AdressView = hiltViewModel()
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        Row (modifier = Modifier.fillMaxWidth()){
            TextField(value = adressView.city, onValueChange = {adressView.city = it} )
        }

        Row (modifier = Modifier.fillMaxWidth()){
            TextField(value = adressView.city, onValueChange = {adressView.city = it} )
        }

        Row (modifier = Modifier.fillMaxWidth()){
            TextField(value = adressView.city, onValueChange = {adressView.city = it} )
        }
        Row (modifier = Modifier.fillMaxWidth()){
            TextField(value = adressView.city, onValueChange = {adressView.city = it} )
        }
        Row (modifier = Modifier.fillMaxWidth()){
            TextField(value = adressView.city, onValueChange = {adressView.city = it} )
        }


    }
}