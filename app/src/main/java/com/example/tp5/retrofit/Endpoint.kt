package com.example.tp5.retrofit

import com.example.tp5.url
import com.example.tp5.entity.Parking
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface Endpoint {


    @GET("gestionParking/getAllParkings")
    suspend fun getAllParkings(): Response<List<Parking>>

    @POST("gestionParking/getParkingByName")
    suspend fun getParkingByName(@Body nom: String): Response<List<Parking>>

    companion object {
        @Volatile
        var endpoint: Endpoint? = null
        fun createInstance(): Endpoint {
            if(endpoint ==null) {
                synchronized(this) {
                    endpoint = Retrofit.Builder().baseUrl(url)
                        .addConverterFactory(GsonConverterFactory.create()).build()
                        .create(Endpoint::class.java)
                }
            }
            return endpoint!!

        }


    }

}
