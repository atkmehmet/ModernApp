package com.example.modernapp.domain.repository

import com.example.modernapp.domain.model.User

interface UserRepository {

    suspend fun insertUser(user: User)

    suspend fun getUser():List<User>

    suspend fun deleteUser(userId:Int)

    suspend fun  insertToApiUser()
}