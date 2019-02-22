package br.com.fernando.pokemonrx.api

import br.com.fernando.pokemonrx.model.Pokemon
import br.com.fernando.pokemonrx.model.PokemonListResponse
import retrofit2.http.GET
import retrofit2.http.Path
import rx.Observable

interface PokemonAPI {

    @GET("api/v2/pokemon")
    fun listaPokemons() : Observable<PokemonListResponse>

    @GET("api/v2/pokemon/{nomePokemon}")
    fun buscaPor(@Path("nomePokemon") nomePokemon: String): Observable<Pokemon>

}