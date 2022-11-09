package com.example.employeetest.restClient

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RestClient {
    val baseUrl = "https://quotable.io/"

    fun getInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}