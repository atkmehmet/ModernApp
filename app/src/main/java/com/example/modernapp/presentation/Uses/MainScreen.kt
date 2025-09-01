package com.example.modernapp.presentation.Uses

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn

import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.foundation.lazy.items
import com.example.modernapp.domain.model.User

@Composable
fun MainScreen(viewModel: MainViewModel ,
               onNavigateToAddress: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)

    ) {
        TextField(
            value = viewModel.name,
            onValueChange = { viewModel.name = it },
            label = { Text(text = "Name") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = viewModel.email,
            onValueChange = { viewModel.email = it },
            label = { Text(text = "Name") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(onClick = { viewModel.onSaveUser() }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Save")

        }

        if (viewModel.message.isNotBlank()) {
            Text(text = viewModel.message)
        }
        UserList(viewModel.users)
        Button(onClick = { onNavigateToAddress}) {
            Text(text = "Add Address")
        }

    }




}



@Composable
fun UserList(userList: List<User>){
    LazyColumn {
        items(userList){user->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(text = "ID: ${user.email}")
                    Text(text = "Name: ${user.name}")
                }
            }

        }
    }
}