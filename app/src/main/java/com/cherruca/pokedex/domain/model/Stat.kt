package com.cherruca.pokedex.domain.model

import com.squareup.moshi.Json

data class Stat(
    @Json(name = "base_stat")
    val baseStat: Long,
    val effort: Long,
    val stat: StatDetail
)

data class StatDetail(
    val name: String,
    val url: String
)