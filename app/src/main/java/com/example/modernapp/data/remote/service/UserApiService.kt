package com.example.modernapp.data.remote.service

import com.example.modernapp.data.remote.model.ApiResponse
import retrofit2.http.GET

interface UserApiService {
    @GET("users")
    suspend fun getUsers():List<ApiResponse>
}