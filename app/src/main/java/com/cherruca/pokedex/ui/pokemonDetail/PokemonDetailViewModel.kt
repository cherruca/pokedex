package com.cherruca.pokedex.ui.pokemonDetail

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cherruca.pokedex.domain.model.PokemonDetailResponse
import com.cherruca.pokedex.network.PokeApi
import kotlinx.coroutines.launch

class PokemonDetailViewModel : ViewModel() {
    private val _pokemonDetail = MutableLiveData<PokemonDetailResponse?>()
    val pokemonDetail: MutableLiveData<PokemonDetailResponse?>
        get() = _pokemonDetail

    fun getPokemonDetail(name: String) {
        viewModelScope.launch {
            try {
                _pokemonDetail.value = PokeApi.retrofitService.getPokemonDetail(name)

            } catch (e: Exception) {
                _pokemonDetail.value = null
                Log.e("ERROR", "incorrecta conexión a API")
            }
        }
    }
}