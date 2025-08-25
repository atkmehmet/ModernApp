package com.example.modernapp.di

import android.content.Context
import androidx.room.Room
import com.example.modernapp.data.local.dao.UserDao
import com.example.modernapp.data.local.database.AppDatabase
import com.example.modernapp.data.local.repository.UserRepositoryImpl
import com.example.modernapp.domain.repository.UserRepository
import com.example.modernapp.domain.usecase.UserInsertCase
import com.example.modernapp.domain.usecase.UserList
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
        object AppModule
        {
             @Provides
             fun providesUserRepository(userDao: UserDao):UserRepository{
                 return UserRepositoryImpl(userDao)
             }

            @Provides
            fun providesUserCase(userRepository: UserRepository):UserInsertCase{
                return  UserInsertCase(userRepository)
            }

            @Provides
            fun providesUserList(userRepository: UserRepository):UserList{
                return  UserList(userRepository)
            }

            @Provides
            fun providesUserDao(appDatabase: AppDatabase):UserDao{
                return appDatabase.userDao()
            }
            @Provides
            @Singleton
            fun providesAppDatabase(@ApplicationContext contex:Context):AppDatabase{
                return Room.databaseBuilder(
                    contex,
                    AppDatabase::class.java,
                    "user_db"
                ).build()
            }
        }