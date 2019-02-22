package br.com.fernando.pokemonrx.listapokemons

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import br.com.fernando.pokemonrx.R
import br.com.fernando.pokemonrx.model.Pokemon

class PokemonsAdapter (val context: Context,
                       val pokemons:List<Pokemon>,
                       val listener: (Pokemon) -> Unit): RecyclerView.Adapter<PokemonViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val view = LayoutInflater.from(context)
                .inflate(R.layout.meu_pokemon_item,parent,false)
        return PokemonViewHolder(view)
    }

    override fun getItemCount(): Int {
        return pokemons.size
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val jogo = pokemons[position]
        holder.let {
            it.bindView(jogo, listener)
        }
    }

}