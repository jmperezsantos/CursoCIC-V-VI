package mx.ipn.cic.pokedex.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import mx.ipn.cic.pokedex.R
import mx.ipn.cic.pokedex.adapter.PokemonRecyclerAdapter
import mx.ipn.cic.pokedex.services.PokemonService

class PokemonListFragment : Fragment() {

    private lateinit var pokemonRecycler: RecyclerView
    private lateinit var lavLoader: LottieAnimationView

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

        this.lavLoader = view.findViewById(R.id.lavLoader)
        this.pokemonRecycler = view.findViewById(R.id.rvPokemons)
        this.pokemonRecycler.layoutManager = LinearLayoutManager(this.context)

    }

    override fun onStart() {
        super.onStart()
        //Los consumos de WS o BD van aqui ;)

        this.lavLoader.visibility = View.VISIBLE
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

                    val fragment = PokemonDetailFragment.newInstance(selectedPokemon)

                    val transaction = this.parentFragmentManager.beginTransaction()
                    transaction.replace(
                        R.id.pokeContainer,
                        fragment
                    )
                    transaction.addToBackStack(null)
                    transaction.commit()

                }

                this.pokemonRecycler.adapter = adapter

                this.lavLoader.visibility = View.INVISIBLE
            },
            { error ->

                Toast.makeText(
                    this.context,
                    "Error: $error",
                    Toast.LENGTH_LONG
                ).show()

                this.lavLoader.visibility = View.INVISIBLE
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