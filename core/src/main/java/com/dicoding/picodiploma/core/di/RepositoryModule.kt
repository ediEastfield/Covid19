package com.dicoding.picodiploma.core.di

import com.dicoding.picodiploma.core.data.CovidRepository
import com.dicoding.picodiploma.core.domain.repository.ICovidRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module(includes = [NetworkModule::class, DatabaseModule::class])
@InstallIn(ApplicationComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(covidRepository: CovidRepository): ICovidRepository

}