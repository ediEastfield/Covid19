package com.dicoding.picodiploma.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dicoding.picodiploma.core.data.source.local.entity.ArticleEntity
import com.dicoding.picodiploma.core.data.source.local.entity.CountryEntity

@Database(
        entities = [CountryEntity::class, ArticleEntity::class],
        version = 1,
        exportSchema = false
)
abstract class CovidDatabase : RoomDatabase() {

    abstract fun covidDao(): CovidDao

}