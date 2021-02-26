package com.dicoding.picodiploma.core.domain.repository

import com.dicoding.picodiploma.core.data.Resource
import com.dicoding.picodiploma.core.domain.model.Article
import com.dicoding.picodiploma.core.domain.model.Country
import kotlinx.coroutines.flow.Flow

interface ICovidRepository {

    fun getAllCountryData(): Flow<Resource<List<Country>>>

    fun getAllNews(): Flow<Resource<List<Article>>>

    fun getBookmarkNews(): Flow<List<Article>>

    fun setBookmarkNews(article: Article, state: Boolean)
}