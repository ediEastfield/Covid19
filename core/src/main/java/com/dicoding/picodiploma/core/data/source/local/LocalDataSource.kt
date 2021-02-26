package com.dicoding.picodiploma.core.data.source.local

import com.dicoding.picodiploma.core.data.source.local.entity.ArticleEntity
import com.dicoding.picodiploma.core.data.source.local.entity.CountryEntity
import com.dicoding.picodiploma.core.data.source.local.room.CovidDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSource @Inject constructor(
        private val covidDao: CovidDao
) {

    fun getAllCountryData(): Flow<List<CountryEntity>> = covidDao.getAllCountry()

    suspend fun insertCountry(countryList: List<CountryEntity>) = covidDao.insertCountry(countryList)

    fun getAllNews(): Flow<List<ArticleEntity>> = covidDao.getAllNews()

    fun getBookmarkNews(): Flow<List<ArticleEntity>> = covidDao.getBookmarkNews()

    suspend fun insertNews(articleList: List<ArticleEntity>) = covidDao.insertArticle(articleList)

    fun setBookmarkNews(article: ArticleEntity, newState: Boolean) {
        article.isBookmark = newState
        covidDao.updateBookmarkArticle(article)
    }
}