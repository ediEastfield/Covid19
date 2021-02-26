package com.dicoding.picodiploma.core.data

import com.dicoding.picodiploma.core.data.source.local.LocalDataSource
import com.dicoding.picodiploma.core.data.source.remote.RemoteDataSource
import com.dicoding.picodiploma.core.data.source.remote.network.ApiResponse
import com.dicoding.picodiploma.core.data.source.remote.response.ArticleItemResponse
import com.dicoding.picodiploma.core.data.source.remote.response.ListCountryResponse
import com.dicoding.picodiploma.core.domain.model.Article
import com.dicoding.picodiploma.core.domain.model.Country
import com.dicoding.picodiploma.core.domain.repository.ICovidRepository
import com.dicoding.picodiploma.core.utils.AppExecutors
import com.dicoding.picodiploma.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CovidRepository @Inject constructor(
        private val remoteDataSource: RemoteDataSource,
        private val localDataSource: LocalDataSource,
        private val appExecutors: AppExecutors
) : ICovidRepository {

    override fun getAllCountryData(): Flow<Resource<List<Country>>> =
            object : NetworkBoundResource<List<Country>, ListCountryResponse>() {
                override fun loadFromDB(): Flow<List<Country>> {
                    return localDataSource.getAllCountryData().map {
                        DataMapper.mapEntitiesToDomain(it)
                    }
                }

                override fun shouldFetch(data: List<Country>?): Boolean =
                        data == null || data.isEmpty()

                override suspend fun createCall(): Flow<ApiResponse<ListCountryResponse>> =
                        remoteDataSource.getAllCountryData()

                override suspend fun saveCallResult(data: ListCountryResponse) {
                    val countrylist = DataMapper.mapResponseToEntities(data)
                    localDataSource.insertCountry(countrylist)
                }
                
            }.asFlow()

    override fun getAllNews(): Flow<Resource<List<Article>>> =
            object : NetworkBoundResource<List<Article>, List<ArticleItemResponse>>() {
                override fun loadFromDB(): Flow<List<Article>> {
                    return localDataSource.getAllNews().map {
                        DataMapper.mapNewsEntitiesToDomain(it)
                    }
                }

                override fun shouldFetch(data: List<Article>?): Boolean =
                        true

                override suspend fun createCall(): Flow<ApiResponse<List<ArticleItemResponse>>> =
                        remoteDataSource.getAllNews()

                override suspend fun saveCallResult(data: List<ArticleItemResponse>) {
                    val newsList = DataMapper.mapNewsResponsesToEntities(data)
                    localDataSource.insertNews(newsList)
                }
            }.asFlow()

    override fun getBookmarkNews(): Flow<List<Article>> {
        return localDataSource.getBookmarkNews().map {
            DataMapper.mapNewsEntitiesToDomain(it)
        }
    }

    override fun setBookmarkNews(article: Article, state: Boolean) {
        val articleEntity = DataMapper.mapDomainToNewsEntity(article)
        appExecutors.diskIO().execute { localDataSource.setBookmarkNews(articleEntity, state) }
    }
}