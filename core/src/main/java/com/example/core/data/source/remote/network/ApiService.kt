package com.example.core.data.source.remote.network

import com.example.core.data.source.remote.response.ListNewsResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {
    @GET("v2/top-headlines")
    @Headers("x-api-key: 8b5cd4d2bfe54dfdb6cfe072c829df3f")
    suspend fun getList(
        @Query("country") country: String = "id",
        @Query("category") category: String = "technology",
        @Query("pageSize") pageSize: Int = 100
    ): ListNewsResponse
}