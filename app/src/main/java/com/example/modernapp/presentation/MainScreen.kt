package com.example.modernapp.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MainScreen(viewModel: MainViewModel = hiltViewModel()) {
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
            Text(text =viewModel.message,Color.Red )
        }
    }


}