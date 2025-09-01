package com.example.modernapp.presentation.Adress

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun AdressScreen(
    adressView: AdressView,
    onBack:()->Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        TextField(
            value = adressView.city,
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "city")},
            onValueChange = { adressView.city = it })



        TextField(
            value = adressView.street,
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "street")},
            onValueChange = { adressView.street = it })



        TextField(
            value = adressView.zipcode,
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "zipcode")},
            onValueChange = { adressView.zipcode = it })


        TextField(
            value = adressView.idUser.toString(),
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "idUser")},
            onValueChange = { adressView.idUser = it.toInt() })




        Button(onClick = { adressView.InsertAdress() }) {
            Text(text = "Save Adress")

        }
        
        Button(onClick = { onBack }) {
            Text(text = "Back User Screen")
        }
        
        if (adressView.message!="")
        {
            Text(text = adressView.message)
        }
        adressView.adressList.onEach {adress->
            
            Text(text = adress.city)
            
        }

    }
}