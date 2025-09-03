package com.example.modernapp.di

import android.content.Context
import androidx.room.Room
import com.example.modernapp.data.local.dao.Adressdao
import com.example.modernapp.data.local.dao.UserDao
import com.example.modernapp.data.local.database.AppDatabase
import com.example.modernapp.data.local.repository.AdressRepositoryImpl
import com.example.modernapp.data.local.repository.UserRepositoryImpl
import com.example.modernapp.data.remote.service.UserApiService
import com.example.modernapp.domain.repository.AdressRepository
import com.example.modernapp.domain.repository.UserRepository
import com.example.modernapp.domain.usecase.AdressInsertCase
import com.example.modernapp.domain.usecase.AdressListCase
import com.example.modernapp.domain.usecase.UserInsertCase
import com.example.modernapp.domain.usecase.UserList
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
        object AppModule
        {
             @Provides
             fun providesUserRepository(userDao: UserDao,apiService: UserApiService):UserRepository{
                 return UserRepositoryImpl(userDao,apiService)
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
            fun providesAdressInsertCase(adressRepository: AdressRepository):AdressInsertCase{
                return AdressInsertCase(adressRepository)
            }
            @Provides
            fun providersAdressListCase(adressRepository: AdressRepository):AdressListCase{
                return AdressListCase(adressRepository)
            }

            @Provides
            fun providesAdressRepository(adressdao: Adressdao,userApiService: UserApiService):AdressRepository{
                return AdressRepositoryImpl(adressdao,userApiService)
            }

            @Provides
            fun providesUserDao(appDatabase: AppDatabase):UserDao{
                return appDatabase.userDao()
            }
            @Provides
            fun providesAdressDao(appDatabase: AppDatabase):Adressdao{
                return appDatabase.adressDao()
            }

            @Provides
            @Singleton
            fun provideRetrofit() :Retrofit =
                Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

            @Provides
            fun provideApi(retrofit: Retrofit):UserApiService =
                retrofit.create(UserApiService::class.java)

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