package com.dicoding.picodiploma.core.di

import android.content.Context
import androidx.room.Room
import com.dicoding.picodiploma.core.data.source.local.room.CovidDao
import com.dicoding.picodiploma.core.data.source.local.room.CovidDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class DatabaseModule {

    val passphrase: ByteArray = SQLiteDatabase.getBytes("covid19".toCharArray())

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): CovidDatabase = Room.databaseBuilder(
        context,
        CovidDatabase::class.java,
        "Covid19.db"
    )
        .fallbackToDestructiveMigration()
            .openHelperFactory(SupportFactory(passphrase))
        .build()

    @Provides
    fun provideCovidDao(database: CovidDatabase): CovidDao = database.covidDao()
}