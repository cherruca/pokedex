package com.cherruca.pokedex.domain.repository.pokemonUI

import android.util.Log
import com.cherruca.pokedex.domain.model.PokemonDetailResponse
import com.cherruca.pokedex.domain.model.PokemonUI

class PokemonUIRepositoryImp: PokemonUIRepository {
    var pokemonUIList: MutableSet<PokemonUI> = PokemonUIDataSource.pokemonUIList

    override fun addPokemon(pokemonDetailResponse: PokemonDetailResponse?) {
        val newPokemonUI = pokemonDetailResponse?.let {
            PokemonUI(
                name = it.name,
                imageDefault = pokemonDetailResponse.sprites.frontDefault
            )
        }

        if (newPokemonUI != null) {
            pokemonUIList.add(newPokemonUI)
            Log.d("ADDITION", newPokemonUI.name)
        }
    }

}