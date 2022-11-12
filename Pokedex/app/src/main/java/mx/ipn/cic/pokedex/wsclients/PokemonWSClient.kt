package mx.ipn.cic.pokedex.wsclients

import mx.ipn.cic.pokedex.dto.PokemonDTO
import mx.ipn.cic.pokedex.dto.PokemonListResponse
import mx.ipn.cic.pokedex.dto.PokemonResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonWSClient {

    @GET("/api/v2/pokemon")
    fun getAllPokemons(): Call<PokemonListResponse>

    @GET("/api/v2/pokemon/{pokemonName}")
    fun getPokemonByName(
        @Path("pokemonName") pokemonName: String
    ): Call<PokemonDTO>

}