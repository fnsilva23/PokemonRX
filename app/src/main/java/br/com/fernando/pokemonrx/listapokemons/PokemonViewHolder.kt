package br.com.fernando.pokemonrx.listapokemons

import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.View
import br.com.fernando.pokemonrx.R
import br.com.fernando.pokemonrx.R.id.ivPokemon
import br.com.fernando.pokemonrx.model.Pokemon
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.meu_pokemon_item.view.*

class PokemonViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {


    fun bindView (pokemon: Pokemon, listener: (Pokemon) -> Unit) = with (itemView){
        tvPokemon.text = pokemon.name
        Picasso.get()
                .load(pokemon.sprites.frontDefault)
                .into(ivPokemon)
    }
}
