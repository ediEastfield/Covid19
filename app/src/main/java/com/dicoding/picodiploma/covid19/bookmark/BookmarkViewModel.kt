package com.dicoding.picodiploma.covid19.bookmark

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.picodiploma.core.domain.usecase.CovidUseCase

class BookmarkViewModel @ViewModelInject constructor(covidUseCase: CovidUseCase) : ViewModel() {
    val bookmarkNews = covidUseCase.getBookmarkNews().asLiveData()
}