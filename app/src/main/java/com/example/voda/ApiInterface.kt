package com.example.voda

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("Airlines")
    fun getAirlines(): Call<Airline>
}