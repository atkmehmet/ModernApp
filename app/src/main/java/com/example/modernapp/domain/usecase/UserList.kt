package com.example.modernapp.domain.usecase

import com.example.modernapp.domain.model.User
import com.example.modernapp.domain.repository.UserRepository

class UserList(
    private val repository: UserRepository
) {
    suspend operator fun invoke ():List<User>{
        return repository.getUser()
    }
}