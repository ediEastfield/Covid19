package com.dicoding.picodiploma.covid19.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.picodiploma.core.domain.usecase.CovidUseCase

class HomeViewModel @ViewModelInject constructor(covidUseCase: CovidUseCase) : ViewModel() {
    val country = covidUseCase.getAllCountryData().asLiveData()
}