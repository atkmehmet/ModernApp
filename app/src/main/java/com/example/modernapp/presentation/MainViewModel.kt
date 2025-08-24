package com.example.modernapp.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.modernapp.domain.model.User
import com.example.modernapp.domain.usecase.UserInsertCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val userInsertCase: UserInsertCase
) :ViewModel() {
  var name by mutableStateOf("")
  var email by mutableStateOf("")
  var message   by mutableStateOf("")

     fun onSaveUser(){
      viewModelScope.launch {
          try {
              userInsertCase(User(name=name,email= email))
          }
          catch (ex:Exception){
              message = ex.toString()
          }


      }
     }

}