package com.dicoding.picodiploma.covid19.di

import com.dicoding.picodiploma.core.domain.usecase.CovidInteractor
import com.dicoding.picodiploma.core.domain.usecase.CovidUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
abstract class AppModule {

    @Binds
    abstract fun provideCovidUseCase(covidInteractor: CovidInteractor): CovidUseCase
}