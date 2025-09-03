package com.example.modernapp.data.local.repository

import com.example.modernapp.data.local.dao.UserDao
import com.example.modernapp.data.local.entities.UserEntity
import com.example.modernapp.data.remote.service.UserApiService
import com.example.modernapp.domain.model.User
import com.example.modernapp.domain.repository.UserRepository

class UserRepositoryImpl(
    private val userDao: UserDao,
    private val apiService: UserApiService
):UserRepository {
    override suspend fun insertUser(user: User) {

        val entity = UserEntity(name = user.name, email = user.email)
        userDao.insertUser(entity)
    }

    override suspend fun getUser(): List<User> {

      val userEntity =  userDao.getAllUsers()
        return  userEntity.map {entity->
            User(
                name = entity.name,
                email = entity.email
            )
        }
    }


    override suspend fun deleteUser(userId: Int) {
        userDao.deleteUser(userId)
    }

    override suspend fun insertToApiUser() {
       val users = apiService.getUsers()
        users.forEach {
            userDao.insertUser(UserEntity(
                name = it.name,
                email = it.email
            ))
        }
    }

}