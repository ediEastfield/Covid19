package com.dicoding.picodiploma.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "country")
data class CountryEntity(
        @PrimaryKey
        @NonNull
        @ColumnInfo(name = "country")
        var country: String,

        @ColumnInfo(name = "confirmed")
        var confirmed: Int? = 0,

        @ColumnInfo(name = "recovered")
        var recovered: Int? = 0,

        @ColumnInfo(name = "deaths")
        var deaths: Int? = 0
)
