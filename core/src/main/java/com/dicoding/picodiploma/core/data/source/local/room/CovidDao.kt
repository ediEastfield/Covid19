package com.dicoding.picodiploma.core.data.source.local.room

import androidx.room.*
import com.dicoding.picodiploma.core.data.source.local.entity.ArticleEntity
import com.dicoding.picodiploma.core.data.source.local.entity.CountryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CovidDao {

    @Query("SELECT * FROM country ORDER BY confirmed DESC")
    fun getAllCountry(): Flow<List<CountryEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCountry(country: List<CountryEntity>)

    @Query("SELECT * FROM article")
    fun getAllNews(): Flow<List<ArticleEntity>>

    @Query("SELECT * FROM article WHERE isFavorite = 1")
    fun getBookmarkNews(): Flow<List<ArticleEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArticle(article: List<ArticleEntity>)

    @Update
    fun updateBookmarkArticle(article: ArticleEntity)
}