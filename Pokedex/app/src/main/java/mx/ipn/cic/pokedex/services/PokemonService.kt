package mx.ipn.cic.pokedex.services

import mx.ipn.cic.pokedex.dto.PokemonDTO
import mx.ipn.cic.pokedex.dto.PokemonListResponse
import mx.ipn.cic.pokedex.dto.PokemonResult
import mx.ipn.cic.pokedex.wsclients.PokemonWSClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PokemonService {

    companion object {
        val instance: PokemonService = PokemonService()
    }

    private val pokemonWSClient: PokemonWSClient

    private constructor() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        pokemonWSClient = retrofit.create(PokemonWSClient::class.java)
    }

    fun getAllPokemons(
        success: (List<PokemonResult>) -> Unit,
        error: (String) -> Unit
    ) {

        pokemonWSClient.getAllPokemons()
            .enqueue(object : Callback<PokemonListResponse> {
                override fun onResponse(
                    call: Call<PokemonListResponse>,
                    response: Response<PokemonListResponse>
                ) {

                    if (response.isSuccessful) {
                        val pokeResponse = response.body()!!
                        success(pokeResponse.results)
                    } else {
                        error(response.message())
                    }

                }

                override fun onFailure(
                    call: Call<PokemonListResponse>,
                    t: Throwable
                ) {
                    error(t.message.toString())
                }

            })
    }

    fun getPokemonByName(
        pokemonName: String,
        success: (PokemonDTO) -> Unit,
        error: (String) -> Unit
    ) {

        this.pokemonWSClient.getPokemonByName(pokemonName)
            .enqueue(object : Callback<PokemonDTO> {
                override fun onResponse(
                    call: Call<PokemonDTO>,
                    response: Response<PokemonDTO>
                ) {

                    if (response.isSuccessful) {
                        val pokemon = response.body()!!
                        success(pokemon)
                    } else {
                        error(response.message())
                    }

                }

                override fun onFailure(
                    call: Call<PokemonDTO>,
                    t: Throwable
                ) {
                    error(t.message.toString())
                }

            })

    }

}