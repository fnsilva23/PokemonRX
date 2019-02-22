package br.com.fernando.pokemonrx

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import android.view.animation.GridLayoutAnimationController
import android.widget.GridLayout
import br.com.fernando.pokemonrx.api.PokemonService
import br.com.fernando.pokemonrx.listapokemons.PokemonsAdapter
import br.com.fernando.pokemonrx.model.Pokemon
import kotlinx.android.synthetic.main.activity_main.*
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    lateinit var adapter: PokemonsAdapter

    var pokemons = ArrayList<Pokemon>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val api = PokemonService()

        adapter = PokemonsAdapter(this, pokemons, {})
        rvPokemons.adapter = adapter

        rvPokemons.layoutManager = GridLayoutManager(this, 3)

        api.loadPokemons()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            Log.i("POKEMON", "${it.name} - ${it.sprites.frontDefault}")
                            pokemons.add(it)
                        },
                        {e -> e.printStackTrace()},
                        {
                            //Log.i("POKEMON","Todos pokemons emitidos")
                            adapter.notifyDataSetChanged()
                        }
                )

    }
}
