package com.dicoding.picodiploma.core.utils

import com.dicoding.picodiploma.core.data.source.local.entity.ArticleEntity
import com.dicoding.picodiploma.core.data.source.local.entity.CountryEntity
import com.dicoding.picodiploma.core.data.source.remote.response.ArticleItemResponse
import com.dicoding.picodiploma.core.data.source.remote.response.ListCountryResponse
import com.dicoding.picodiploma.core.domain.model.Article
import com.dicoding.picodiploma.core.domain.model.Country

object DataMapper {
    fun mapResponseToEntities(input: ListCountryResponse): List<CountryEntity> {
        val countryList = ArrayList<CountryEntity>()

        val uS = CountryEntity(
            country = input.uS.all.country.toString(),
            confirmed = input.uS.all.confirmed,
            recovered = input.uS.all.recovered,
            deaths = input.uS.all.deaths
        )
        countryList.add(uS)

        val australia = CountryEntity(
                country = input.australia.all.country.toString(),
                confirmed = input.australia.all.confirmed,
                recovered = input.australia.all.recovered,
                deaths = input.australia.all.deaths
        )
        countryList.add(australia)

        val china = CountryEntity(
                country = input.china.all.country.toString(),
                confirmed = input.china.all.confirmed,
                recovered = input.china.all.recovered,
                deaths = input.china.all.deaths
        )
        countryList.add(china)

        val france = CountryEntity(
                country = input.france.all.country.toString(),
                confirmed = input.france.all.confirmed,
                recovered = input.france.all.recovered,
                deaths = input.france.all.deaths
        )
        countryList.add(france)

        val germany = CountryEntity(
                country = input.germany.all.country.toString(),
                confirmed = input.germany.all.confirmed,
                recovered = input.germany.all.recovered,
                deaths = input.germany.all.deaths
        )
        countryList.add(germany)

        val india = CountryEntity(
                country = input.india.all.country.toString(),
                confirmed = input.india.all.confirmed,
                recovered = input.india.all.recovered,
                deaths = input.india.all.deaths
        )
        countryList.add(india)

        val indonesia = CountryEntity(
                country = input.indonesia.all.country.toString(),
                confirmed = input.indonesia.all.confirmed,
                recovered = input.indonesia.all.recovered,
                deaths = input.indonesia.all.deaths
        )
        countryList.add(indonesia)

        val iran = CountryEntity(
                country = input.iran.all.country.toString(),
                confirmed = input.iran.all.confirmed,
                recovered = input.iran.all.recovered,
                deaths = input.iran.all.deaths
        )
        countryList.add(iran)

        val iraq = CountryEntity(
                country = input.iraq.all.country.toString(),
                confirmed = input.iraq.all.confirmed,
                recovered = input.iraq.all.recovered,
                deaths = input.iraq.all.deaths
        )
        countryList.add(iraq)

        val israel = CountryEntity(
                country = input.israel.all.country.toString(),
                confirmed = input.israel.all.confirmed,
                recovered = input.israel.all.recovered,
                deaths = input.israel.all.deaths
        )
        countryList.add(israel)

        val italy = CountryEntity(
                country = input.italy.all.country.toString(),
                confirmed = input.italy.all.confirmed,
                recovered = input.italy.all.recovered,
                deaths = input.italy.all.deaths
        )
        countryList.add(italy)

        val japan = CountryEntity(
                country = input.japan.all.country.toString(),
                confirmed = input.japan.all.confirmed,
                recovered = input.japan.all.recovered,
                deaths = input.japan.all.deaths
        )
        countryList.add(japan)

        val korea = CountryEntity(
                country = input.koreaSouth.all.country.toString(),
                confirmed = input.koreaSouth.all.confirmed,
                recovered = input.koreaSouth.all.recovered,
                deaths = input.koreaSouth.all.deaths
        )
        countryList.add(korea)

        val malaysia = CountryEntity(
                country = input.malaysia.all.country.toString(),
                confirmed = input.malaysia.all.confirmed,
                recovered = input.malaysia.all.recovered,
                deaths = input.malaysia.all.deaths
        )
        countryList.add(malaysia)

        val netherlands = CountryEntity(
                country = input.netherlands.all.country.toString(),
                confirmed = input.netherlands.all.confirmed,
                recovered = input.netherlands.all.recovered,
                deaths = input.netherlands.all.deaths
        )
        countryList.add(netherlands)

        val russia = CountryEntity(
                country = input.russia.all.country.toString(),
                confirmed = input.russia.all.confirmed,
                recovered = input.russia.all.recovered,
                deaths = input.russia.all.deaths
        )
        countryList.add(russia)

        val saudiArabia = CountryEntity(
                country = input.saudiArabia.all.country.toString(),
                confirmed = input.saudiArabia.all.confirmed,
                recovered = input.saudiArabia.all.recovered,
                deaths = input.saudiArabia.all.deaths
        )
        countryList.add(saudiArabia)

        val singapore = CountryEntity(
                country = input.singapore.all.country.toString(),
                confirmed = input.singapore.all.confirmed,
                recovered = input.singapore.all.recovered,
                deaths = input.singapore.all.deaths
        )
        countryList.add(singapore)

        val spain = CountryEntity(
                country = input.spain.all.country.toString(),
                confirmed = input.spain.all.confirmed,
                recovered = input.spain.all.recovered,
                deaths = input.spain.all.deaths
        )
        countryList.add(spain)

        val thailand = CountryEntity(
                country = input.thailand.all.country.toString(),
                confirmed = input.thailand.all.confirmed,
                recovered = input.thailand.all.recovered,
                deaths = input.thailand.all.deaths
        )
        countryList.add(thailand)

        val unitedKingdom = CountryEntity(
                country = input.unitedKingdom.all.country.toString(),
                confirmed = input.unitedKingdom.all.confirmed,
                recovered = input.unitedKingdom.all.recovered,
                deaths = input.unitedKingdom.all.deaths
        )
        countryList.add(unitedKingdom)

        return countryList
    }

    fun mapEntitiesToDomain(input: List<CountryEntity>): List<Country> =
            input.map {
                Country(
                        country = it.country,
                        confirmed = it.confirmed,
                        recovered = it.recovered,
                        deaths = it.deaths
                )
            }

    fun mapNewsResponsesToEntities(input: List<ArticleItemResponse>): List<ArticleEntity> {
        val articleList = ArrayList<ArticleEntity>()
        input.map {
            val article = ArticleEntity(
                    url = it.url,
                    publishedAt = it.publishedAt,
                    author = it.author,
                    urlToImage = it.urlToImage,
                    description = it.description,
                    title = it.title,
                    content = it.content,
                    isBookmark = false
            )
            articleList.add(article)
        }
        return articleList
    }

    fun mapNewsEntitiesToDomain(input: List<ArticleEntity>): List<Article> =
            input.map {
                Article(
                        url = it.url,
                        publishedAt = it.publishedAt,
                        author = it.author,
                        urlToImage = it.urlToImage,
                        description = it.description,
                        title = it.title,
                        content = it.content,
                        isBookmark = it.isBookmark
                )
            }

    fun mapDomainToNewsEntity(input: Article) = ArticleEntity(
            url = input.url,
            publishedAt = input.publishedAt,
            author = input.author,
            urlToImage = input.urlToImage,
            description = input.description,
            title = input.title,
            content = input.content,
            isBookmark = input.isBookmark
    )
}