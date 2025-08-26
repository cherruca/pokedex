package com.cherruca.pokedex.ui.pokemonList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import com.cherruca.pokedex.R
import androidx.recyclerview.widget.RecyclerView
import com.cherruca.pokedex.domain.model.PokemonUI
import coil.load
import com.google.android.material.card.MaterialCardView

class PokemonListAdapter(private val pokemonList: MutableSet<PokemonUI>) : RecyclerView.Adapter<PokemonListAdapter.PokemonListViewHolder>() {
    class PokemonListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val pokemonName: TextView = itemView.findViewById(R.id.pokecard_name)
        val pokemonSprite: ImageView = itemView.findViewById(R.id.pokecard_sprite)
        val pokemonCard: MaterialCardView = itemView.findViewById(R.id.pokecard)
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
        holder.pokemonCard.setOnClickListener {
            it.findNavController().navigate(
                PokemonListFragmentDirections.actionPokemonListFragmentToPokemonDetailFragment(pokemon.name)
            )
        }
    }

    override fun getItemCount() = pokemonList.size
}