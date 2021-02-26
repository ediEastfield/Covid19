package com.dicoding.picodiploma.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListCountryResponse(

        @field:SerializedName("Global")
        val global: All,

        @field:SerializedName("Australia")
        val australia: All,

        @field:SerializedName("Belgium")
        val belgium: All,

        @field:SerializedName("Brazil")
        val brazil: All,

        @field:SerializedName("Brunei")
        val brunei: All,

        @field:SerializedName("Cambodia")
        val cambodia: All,

        @field:SerializedName("Canada")
        val canada: All,

        @field:SerializedName("China")
        val china: All,

        @field:SerializedName("France")
        val france: All,

        @field:SerializedName("Germany")
        val germany: All,

        @field:SerializedName("India")
        val india: All,

        @field:SerializedName("Indonesia")
        val indonesia: All,

        @field:SerializedName("Iran")
        val iran: All,

        @field:SerializedName("Iraq")
        val iraq: All,

        @field:SerializedName("Israel")
        val israel: All,

        @field:SerializedName("Italy")
        val italy: All,

        @field:SerializedName("Japan")
        val japan: All,

        @field:SerializedName("Korea, South")
        val koreaSouth: All,

        @field:SerializedName("Laos")
        val laos: All,

        @field:SerializedName("Malaysia")
        val malaysia: All,

        @field:SerializedName("Netherlands")
        val netherlands: All,

        @field:SerializedName("New Zealand")
        val newZealand: All,

        @field:SerializedName("Philippines")
        val philippines: All,

        @field:SerializedName("Russia")
        val russia: All,

        @field:SerializedName("Saudi Arabia")
        val saudiArabia: All,

        @field:SerializedName("Singapore")
        val singapore: All,

        @field:SerializedName("Spain")
        val spain: All,

        @field:SerializedName("Thailand")
        val thailand: All,

        @field:SerializedName("United Kingdom")
        val unitedKingdom: All,

        @field:SerializedName("Vietnam")
        val vietnam: All,

        @field:SerializedName("US")
        val uS: All

)
