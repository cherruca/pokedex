package com.cherruca.pokedex.ui.pokemonList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.cherruca.pokedex.databinding.FragmentPokemonListBinding

class PokemonListFragment : Fragment() {
    private lateinit var binding: FragmentPokemonListBinding

    private val viewModel: PokemonListViewModel by lazy {
        ViewModelProvider(this)[PokemonListViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPokemonListBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = LinearLayoutManager(context)
        binding.recyclerviewPokemonlist.layoutManager = layoutManager
        viewModel.getPokemons(viewModel.offset)
        viewModel.pokemonDetail.observe(viewLifecycleOwner) { response ->
            binding.recyclerviewPokemonlist.adapter = PokemonListAdapter(viewModel.pokemonUIRepository.pokemonUIList)
        }
    }
}