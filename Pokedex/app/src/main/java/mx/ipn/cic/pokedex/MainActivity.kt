package mx.ipn.cic.pokedex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import mx.ipn.cic.pokedex.fragments.PokemonListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {

            val pokemonList = PokemonListFragment.newInstance()

            val transaction = this.supportFragmentManager.beginTransaction()
            transaction.replace(R.id.pokeContainer, pokemonList)

            transaction.commit()

        }

    }
}