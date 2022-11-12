package mx.ipn.cic.pokedex.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mx.ipn.cic.pokedex.R
import mx.ipn.cic.pokedex.adapter.PokemonRecyclerAdapter
import mx.ipn.cic.pokedex.services.PokemonService

class PokemonListFragment : Fragment() {

    private lateinit var pokemonRecycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pokemon_list, container, false)
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        this.pokemonRecycler = view.findViewById(R.id.rvPokemons)
        this.pokemonRecycler.layoutManager = LinearLayoutManager(this.context)

    }

    override fun onStart() {
        super.onStart()
        //Los consumos de WS o BD van aqui ;)

        PokemonService.instance.getAllPokemons(
            { pokemonSummaryList ->

                //instanciar el adapter
                val adapter = PokemonRecyclerAdapter(
                    pokemonSummaryList
                ) { selectedPokemon ->

                    //TODO navegar al detalle del pokemon
                    Toast.makeText(
                        this.context,
                        "Seleccionó: ${selectedPokemon.name}",
                        Toast.LENGTH_LONG
                    ).show()

                }

                this.pokemonRecycler.adapter = adapter

            },
            { error ->

                Toast.makeText(
                    this.context,
                    "Error: $error",
                    Toast.LENGTH_LONG
                ).show()

            }
        )

    }

    companion object {
        @JvmStatic
        fun newInstance() =
            PokemonListFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}