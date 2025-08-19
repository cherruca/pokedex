package com.cherruca.pokedex.domain.model

data class Type(
    val slot: Long,
    val type: TypeDetail
)

data class TypeDetail(
    val name: String,
    val url: String
)