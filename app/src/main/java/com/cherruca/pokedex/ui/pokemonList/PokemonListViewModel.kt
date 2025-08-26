package com.cherruca.pokedex.ui.pokemonList

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cherruca.pokedex.domain.model.PokemonDetailResponse
import com.cherruca.pokedex.domain.model.PokemonResponse
import com.cherruca.pokedex.domain.repository.pokemonUI.PokemonUIRepositoryImp
import com.cherruca.pokedex.network.PokeApi
import kotlinx.coroutines.launch

class PokemonListViewModel : ViewModel() {
    private val _pokemonList = MutableLiveData<PokemonResponse?>()
    val pokemonList: MutableLiveData<PokemonResponse?>
        get() = _pokemonList
    private val _pokemonDetail = MutableLiveData<PokemonDetailResponse?>()
    val pokemonDetail: MutableLiveData<PokemonDetailResponse?>
        get() = _pokemonDetail
    val pokemonUIRepository = PokemonUIRepositoryImp()
    var offset: Int = 0

    init {
        getPokemons(offset)
    }

    fun getPokemons(start: Int) {
        viewModelScope.launch {
            try {
                _pokemonList.value = PokeApi.retrofitService.getPokemonList(start,15)
                _pokemonList.value?.results?.forEach { pokemonResult ->
                    _pokemonDetail.value = PokeApi.retrofitService.getPokemonDetail(pokemonResult.name)
                    pokemonUIRepository.addPokemon(pokemonDetail.value)
                    Log.d("POKEDEX", pokemonDetail.value?.name.toString())
                }
            } catch (e: Exception) {
                _pokemonList.value = null
                Log.e("ERROR", "incorrecta conexión a API")
            }
        }
    }
}