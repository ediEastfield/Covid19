package com.dicoding.picodiploma.core.data.source.remote.network

import com.dicoding.picodiploma.core.BuildConfig
import com.dicoding.picodiploma.core.data.source.remote.response.ListNewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {
    @GET("top-headlines")
    suspend fun getNews(
        @Query("country") country: String = "id",
        @Query("category") category: String = "health",
        @Query("apiKey") newsKey: String = BuildConfig.NEWS_KEY,
    ): ListNewsResponse
}