package mx.ipn.cic.pokedex.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import mx.ipn.cic.pokedex.R
import mx.ipn.cic.pokedex.dto.PokemonResult

class PokemonListViewHolder(view: View) : ViewHolder(view) {

    private val tvName: TextView = view.findViewById(R.id.tvPokemonName)

    fun bindPokemon(pokemonSumary: PokemonResult) {
        this.tvName.text = pokemonSumary.name
    }

}