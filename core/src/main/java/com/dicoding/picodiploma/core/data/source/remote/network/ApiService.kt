package com.dicoding.picodiploma.core.data.source.remote.network

import com.dicoding.picodiploma.core.data.source.remote.response.ListCountryResponse
import retrofit2.http.GET

interface ApiService {
    @GET("cases")
    suspend fun getList(): ListCountryResponse
}