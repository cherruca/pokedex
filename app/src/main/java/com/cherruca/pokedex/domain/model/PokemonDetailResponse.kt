package com.cherruca.pokedex.domain.model

data class PokemonDetailResponse(
    val id: Int,
    val name: String,
    val height: Double,
    val weight: Double,
    val sprites: Sprite,
    val stats: List<Stat>,
    val types: List<Type>,
    val cries: Cry
)