package com.example.tp5.retrofit

import com.example.tp5.url
import com.example.tp5.entity.Parking
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface Endpoint {


    @GET("parking/getall")
    suspend fun getAllMovies(): Response<List<Parking>>

    @GET("parking/getbynom/{nom}")
    suspend fun getMoviesByTitle(@Path("nom") title: String): Response<List<Parking>>

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
