package com.dicoding.picodiploma.core.data.source.remote

import android.util.Log
import com.dicoding.picodiploma.core.data.source.remote.network.ApiResponse
import com.dicoding.picodiploma.core.data.source.remote.network.ApiService
import com.dicoding.picodiploma.core.data.source.remote.network.NewsService
import com.dicoding.picodiploma.core.data.source.remote.response.ArticleItemResponse
import com.dicoding.picodiploma.core.data.source.remote.response.ListCountryResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
  private val apiService: ApiService,
  private val newsService: NewsService
) {

    suspend fun getAllCountryData(): Flow<ApiResponse<ListCountryResponse>> {
        return flow {
            try {
                val response = apiService.getList()
                emit(ApiResponse.Success(response))
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getAllNews(): Flow<ApiResponse<List<ArticleItemResponse>>> {
        return flow {
            try {
                val response = newsService.getNews()
                val dataArray = response.articles
                if (dataArray.isNotEmpty()) {
                    emit(ApiResponse.Success(response.articles))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e : Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}