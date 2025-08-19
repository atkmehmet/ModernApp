package com.example.modernapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.modernapp.domain.model.User
import com.example.modernapp.domain.usecase.UserInsertCase
import kotlinx.coroutines.launch

@HiltViewModel
class MainViewModel @Inject constructor(
    private val userInsertCase: UserInsertCase
) :ViewModel() {
  val name by mutableStateOf("")
  val email by mutableStateOf("")
  val message   by mutableStateOf("")

     fun onSaveUser(){
      viewModelScope.launch {
          userInsertCase(User(name=name,email= email))

      }       }

}