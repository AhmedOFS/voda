package com.example.voda

import android.util.Log
import androidx.annotation.Keep
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor


class AirlineUtil
{
    var Airlines : List<Airline> = mutableListOf()
fun loadValues(client: MyApiEndpointInterface){

val c= client.getAirlines()

     c.enqueue(object : Callback<ArrayList<Airline>> {
         override fun onResponse(
             call: Call<ArrayList<Airline>>,
             response: Response<ArrayList<Airline>>
         ) {
          Log.d("onres","")

         }

         override fun onFailure(call: Call<ArrayList<Airline>>, t: Throwable) {
 Log.d("onfail","")
         }


     })



}



    fun getRetrofitClient(): MyApiEndpointInterface {
        var BASE_URL="https://api.instantwebtools.net/"

        val httpClient = OkHttpClient.Builder()


    val CONTENT_TYPE = "Content-Type"
      val CONTENT_TYPE_VALUE = "application/json"
     val headerint=   Interceptor { chain ->
            val original = chain.request()

            val request = original.newBuilder()
                .header(CONTENT_TYPE, CONTENT_TYPE_VALUE)
                .method(original.method, original.body)

                .build()

            chain.proceed(request)
        }
        httpClient.addInterceptor(headerint)
httpClient.addInterceptor(HttpLoggingInterceptor().apply {

    level=HttpLoggingInterceptor.Level.BODY

})
        val builder: Retrofit.Builder = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(
                GsonConverterFactory.create()
            )

        val retrofit = builder
            .client(
                httpClient.build()
            )
            .build()

    val client = retrofit.create(MyApiEndpointInterface::class.java)
return client
    }



}

public interface MyApiEndpointInterface {

        @GET("v1/airlines")
        fun getAirlines(

        ): Call<ArrayList<Airline>>


}