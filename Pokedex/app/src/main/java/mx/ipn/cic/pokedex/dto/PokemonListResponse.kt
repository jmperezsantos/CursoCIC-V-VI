package mx.ipn.cic.pokedex.dto

data class PokemonListResponse(
    val count: Long,
    val next: String,
    val previous: String,
    val results: List<PokemonResult>
)

data class PokemonResult(
    val name: String,
    val url: String
)