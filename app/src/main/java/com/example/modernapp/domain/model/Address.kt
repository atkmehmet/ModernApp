package com.example.modernapp.domain.model

data  class Address (
    val id:Int,
    val street: String,
    val idUser:Int,
    val suite: String,
    val city: String,
    val zipcode: String
)