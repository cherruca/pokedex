package com.cherruca.pokedex.domain.repository.pokemonUI

import com.cherruca.pokedex.domain.model.PokemonDetailResponse

interface PokemonUIRepository {
    fun addPokemon(pokemonDetailResponse: PokemonDetailResponse?)
}