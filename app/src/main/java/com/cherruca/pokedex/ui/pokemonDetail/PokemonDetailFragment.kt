package com.cherruca.pokedex.ui.pokemonDetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.cherruca.pokedex.databinding.FragmentPokemonDetailBinding
import coil.load
import com.cherruca.pokedex.R

class PokemonDetailFragment : Fragment() {
    private lateinit var binding: FragmentPokemonDetailBinding

    private val viewModel: PokemonDetailViewModel by lazy {
        ViewModelProvider(this)[PokemonDetailViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPokemonDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args = PokemonDetailFragmentArgs.fromBundle(requireArguments())
        viewModel.getPokemonDetail(args.pokemonId)
        viewModel.pokemonDetail.observe(viewLifecycleOwner) { response ->
            binding.txtDetail.text = viewModel.pokemonDetail.value?.name
            binding.imgDetail.load(viewModel.pokemonDetail.value?.sprites?.frontDefault) {
                crossfade(true)
                placeholder(R.drawable.rounded_downloading)
                error(R.drawable.rounded_error)
            }
        }
    }
}