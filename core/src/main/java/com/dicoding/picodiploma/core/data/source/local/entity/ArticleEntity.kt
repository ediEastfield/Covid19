package com.dicoding.picodiploma.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "article")
data class ArticleEntity(
        @PrimaryKey
        @NonNull
        @ColumnInfo(name = "url")
        var url: String,

        @ColumnInfo(name = "publishedAt")
        var publishedAt: String,

        @ColumnInfo(name = "author")
        var author: String? = "",

        @ColumnInfo(name = "urlToImage")
        val urlToImage: String? = "",

        @ColumnInfo(name = "description")
        val description: String? = "",

        @ColumnInfo(name = "title")
        val title: String,

        @ColumnInfo(name = "content")
        val content: String? = "",

        @ColumnInfo(name = "isFavorite")
        var isBookmark: Boolean = false
)