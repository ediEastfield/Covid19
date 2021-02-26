package com.dicoding.picodiploma.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class All(

        @field:SerializedName("All")
        val all: DataAllResponse

)

data class DataAllResponse(

        @field:SerializedName("country")
        val country: String? = null,

        @field:SerializedName("confirmed")
        val confirmed: Int? = null,

        @field:SerializedName("recovered")
        val recovered: Int? = null,

        @field:SerializedName("deaths")
        val deaths: Int? = null
)
