package com.cherruca.pokedex.ui.pokemonDetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.cherruca.pokedex.R
import com.cherruca.pokedex.databinding.FragmentPokemonDetailBinding

class PokemonDetailFragment : Fragment() {
    private lateinit var binding: FragmentPokemonDetailBinding

    private val viewModel: PokemonDetailViewModel by lazy {
        ViewModelProvider(this)[PokemonDetailViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val args = PokemonDetailFragmentArgs.fromBundle(requireArguments())
        binding = FragmentPokemonDetailBinding.inflate(inflater, container, false)
        binding.txtDetail.text = args.pokemonId
        return binding.root
    }
}