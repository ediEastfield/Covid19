package com.dicoding.picodiploma.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListNewsResponse(

        @field:SerializedName("totalResults")
        val totalResults: Int,

        @field:SerializedName("articles")
        val articles: List<ArticleItemResponse>,

        @field:SerializedName("status")
        val status: String
)
