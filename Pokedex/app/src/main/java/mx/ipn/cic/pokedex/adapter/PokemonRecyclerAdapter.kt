package mx.ipn.cic.pokedex.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import mx.ipn.cic.pokedex.R
import mx.ipn.cic.pokedex.dto.PokemonResult
import mx.ipn.cic.pokedex.viewholder.PokemonListViewHolder

class PokemonRecyclerAdapter(
    private val listPokemonSummary: List<PokemonResult>,
    val onSelectItem: (pokemonResult: PokemonResult) -> Unit
) : Adapter<PokemonListViewHolder>() {

    override fun getItemCount(): Int {
        return this.listPokemonSummary.size
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PokemonListViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(
            R.layout.pokemon_item_list,
            parent,
            false
        )

        val viewHolder = PokemonListViewHolder(itemView)

        return viewHolder

    }

    override fun onBindViewHolder(
        holder: PokemonListViewHolder,
        position: Int
    ) {
        val pokemonSummary = this.listPokemonSummary[position]
        holder.bindPokemon(pokemonSummary)
        holder.itemView.setOnClickListener {
            onSelectItem(pokemonSummary)
        }
    }
}