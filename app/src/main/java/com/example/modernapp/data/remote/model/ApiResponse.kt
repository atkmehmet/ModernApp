package com.example.modernapp.data.remote.model

import com.example.modernapp.domain.usecase.AdressListCase

data class ApiResponse(
    val id:Int,
    val name:String,
    val username:String,
    val email:String,
    val address:AdressDto
)
