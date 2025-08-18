package com.example.modernapp.domain.usecase

import com.example.modernapp.domain.model.User
import com.example.modernapp.domain.repository.UserRepository

class UserInsertCase (
    private val userRepository: UserRepository
){
    suspend  operator  fun invoke (user: User){
        userRepository.insertUser(user)
    }

}