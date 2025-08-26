package com.cherruca.pokedex.ui.pokemonList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.cherruca.pokedex.R
import androidx.recyclerview.widget.RecyclerView
import com.cherruca.pokedex.domain.model.PokemonUI
import coil.load

class PokemonListAdapter(private val pokemonList: MutableSet<PokemonUI>) : RecyclerView.Adapter<PokemonListAdapter.PokemonListViewHolder>() {
    class PokemonListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val pokemonName: TextView = itemView.findViewById(R.id.pokecard_name)
        val pokemonSprite: ImageView = itemView.findViewById(R.id.pokecard_sprite)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pokemon_list, parent, false)
        return PokemonListViewHolder(view)
    }

    override fun onBindViewHolder(holder: PokemonListViewHolder, position: Int) {
        val pokemon = pokemonList.elementAt(position)
        holder.pokemonName.text = pokemon.name
        holder.pokemonSprite.load(pokemon.imageDefault) {
            crossfade(true)
            placeholder(R.drawable.rounded_downloading)
            error(R.drawable.rounded_error)
        }
    }

    override fun getItemCount() = pokemonList.size
}