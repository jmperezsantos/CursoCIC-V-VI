package mx.ipn.cic.pokedex.fragments

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.text.style.LineHeightSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.airbnb.lottie.LottieAnimationView
import com.squareup.picasso.Picasso
import mx.ipn.cic.pokedex.R
import mx.ipn.cic.pokedex.dto.PokemonResult
import mx.ipn.cic.pokedex.services.PokemonService
import java.net.URL

class PokemonDetailFragment : Fragment() {

    private lateinit var pokemonResult: PokemonResult

    lateinit var tvPokemonName: TextView
    lateinit var tvPokemonHeight: TextView
    lateinit var tvPokemonWeight: TextView
    lateinit var ivPokemonImage: ImageView
    lateinit var lavLoader: LottieAnimationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            this.pokemonResult =
                it.getSerializable(POKEMON_ARG) as PokemonResult
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pokemon_detail, container, false)
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        this.lavLoader = view.findViewById(R.id.lavLoader)
        this.tvPokemonName = view.findViewById(R.id.tvPokemonName)
        this.tvPokemonHeight = view.findViewById(R.id.tvPokemonHeight)
        this.tvPokemonWeight = view.findViewById(R.id.tvPokemonWeight)
        this.ivPokemonImage = view.findViewById(R.id.ivPokemonImage)

    }

    override fun onStart() {
        super.onStart()

        this.lavLoader.visibility = View.VISIBLE
        PokemonService.instance.getPokemonByName(
            this.pokemonResult.name,
            { pokemonDTO ->

                this.tvPokemonName.text = pokemonDTO.name
                this.tvPokemonHeight.text = "${pokemonDTO.height}"
                this.tvPokemonWeight.text = "${pokemonDTO.weight}"

                //Cargar la imagen
                Picasso.get()
                    .load(pokemonDTO.sprites.other!!.home.frontDefault)
                    .placeholder(R.drawable.placeholder)
                    .into(this.ivPokemonImage)

                this.lavLoader.visibility = View.INVISIBLE

            },
            { error ->

                Toast.makeText(
                    this.context,
                    "No se pudo encontrar al pokemon: $error",
                    Toast.LENGTH_LONG
                ).show()

                this.lavLoader.visibility = View.INVISIBLE
            }
        )

    }

    companion object {

        private const val POKEMON_ARG = "POKEMON_ARG"

        @JvmStatic
        fun newInstance(pokemonResult: PokemonResult) =
            PokemonDetailFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(POKEMON_ARG, pokemonResult)
                }
            }
    }
}