package com.example.newsapp.data.network

import com.example.newsapp.data.model.NewsDTO
import com.example.newsapp.utils.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("everything")
    suspend fun getNews(
        @Query("page") page: Int,
        @Query("sources") sources: String,
        @Query("apiKey") apiKey: String = API_KEY
    ): NewsDTO

    @GET("everything")
    suspend fun searchNews(
        @Query("q") searchQuery : String,
        @Query("page") page: Int,
        @Query("sources") sources: String,
        @Query("apiKey") apiKey: String = API_KEY
    ): NewsDTO
}