package com.dicoding.picodiploma.core.domain.usecase

import com.dicoding.picodiploma.core.domain.model.Article
import com.dicoding.picodiploma.core.domain.repository.ICovidRepository
import javax.inject.Inject

class CovidInteractor @Inject constructor(
        private val covidRepository: ICovidRepository
) : CovidUseCase {
    override fun getAllCountryData() = covidRepository.getAllCountryData()

    override fun getAllNews() = covidRepository.getAllNews()

    override fun getBookmarkNews() = covidRepository.getBookmarkNews()

    override fun setBookmarkNews(article: Article, state: Boolean) = covidRepository.setBookmarkNews(article, state)
}