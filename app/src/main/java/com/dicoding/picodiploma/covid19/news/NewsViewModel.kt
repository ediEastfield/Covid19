package com.dicoding.picodiploma.covid19.news

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.picodiploma.core.domain.usecase.CovidUseCase

class NewsViewModel @ViewModelInject constructor(covidUseCase: CovidUseCase) : ViewModel() {
    val article = covidUseCase.getAllNews().asLiveData()
}