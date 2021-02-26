package com.dicoding.picodiploma.covid19.detailNews

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.dicoding.picodiploma.core.domain.model.Article
import com.dicoding.picodiploma.core.domain.usecase.CovidUseCase

class DetailNewsViewModel @ViewModelInject constructor(
        private val covidUseCase: CovidUseCase
) : ViewModel() {
    fun setBookmarkNews(article: Article, newStatus: Boolean) =
            covidUseCase.setBookmarkNews(article, newStatus)
}