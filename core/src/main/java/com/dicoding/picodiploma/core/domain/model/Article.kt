package com.dicoding.picodiploma.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Article(
        val url: String,
        val publishedAt: String,
        val author: String? = "",
        val urlToImage: String? = "",
        val description: String? = "",
        val title: String,
        val content: String? = "",
        val isBookmark: Boolean
) : Parcelable
