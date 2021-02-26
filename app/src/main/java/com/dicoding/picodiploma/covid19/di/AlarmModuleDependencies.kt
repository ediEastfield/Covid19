package com.dicoding.picodiploma.covid19.di

import com.dicoding.picodiploma.core.domain.usecase.CovidUseCase
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@EntryPoint
@InstallIn(ApplicationComponent::class)
interface AlarmModuleDependencies {

    fun covidUseCase(): CovidUseCase
}