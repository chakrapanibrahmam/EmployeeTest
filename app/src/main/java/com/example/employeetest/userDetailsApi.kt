package com.example.employeetest

import com.example.employeetest.data.UserData
import retrofit2.Response
import retrofit2.http.GET

interface userDetailsApi {
    @GET("/quotes")
    suspend fun getUserDetailsApi() : Response<UserData>
}