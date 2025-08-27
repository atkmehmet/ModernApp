package com.example.modernapp.presentation.Uses

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.modernapp.domain.model.User
import com.example.modernapp.domain.usecase.UserInsertCase
import com.example.modernapp.domain.usecase.UserList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val userInsertCase: UserInsertCase,
    private val userListcase: UserList
) :ViewModel() {
  var name by mutableStateOf("")
  var email by mutableStateOf("")
  var message   by mutableStateOf("")
    var users by mutableStateOf(listOf<User>())

    init{
        viewModelScope.launch {
            users = userListcase()
        }

    }

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