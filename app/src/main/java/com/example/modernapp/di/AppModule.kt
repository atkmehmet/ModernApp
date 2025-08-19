package com.example.modernapp.di

import com.example.modernapp.data.local.dao.UserDao
import com.example.modernapp.data.local.database.AppDatabase
import com.example.modernapp.data.local.repository.UserRepositoryImpl
import com.example.modernapp.domain.repository.UserRepository
import com.example.modernapp.domain.usecase.UserInsertCase

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
            fun providesUserDao(appDatabase: AppDatabase):UserDao{
                return appDatabase.userDao()
            }
            @Provides
            @Singleton
            fun providesAppDatabase(@Applicationcontex contex):AppDatabase{
                return Room.databaseBuilder(
                    contex,
                    AppDatabase::class.java,
                    "user_db"
                ).build()
            }
        }