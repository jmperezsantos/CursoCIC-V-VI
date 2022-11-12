package mx.ipn.cic.pokedex.dto

import java.io.Serializable

data class PokemonListResponse(
    val count: Long,
    val next: String,
    val previous: String,
    val results: List<PokemonResult>
) : Serializable

data class PokemonResult(
    val name: String,
    val url: String
) : Serializable