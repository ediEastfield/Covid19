package com.dicoding.picodiploma.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Country(
        val country: String? = "",
        val confirmed: Int? = 0,
        val recovered: Int? = 0,
        val deaths: Int? = 0,
) : Parcelable
