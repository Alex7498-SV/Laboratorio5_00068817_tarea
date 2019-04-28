package com.ralex.pokedex

import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.ralex.pokedex.Adapters.PokeAdapter
import com.ralex.pokedex.Interface.AuxInterface
import com.ralex.pokedex.NetUtils.ApiConnect
import com.ralex.pokedex.Utils.Pokemon
import kotlinx.android.synthetic.main.activity_aux.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), AuxInterface {
    override fun finished(response: String) {
        Log.d("Response", response)
    }

    private lateinit var viewAdapter: PokeAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aux)



        Boton1.setOnClickListener { v->
            ApiConnect(this).execute()
         }



        //recycler()
    }

    fun recycler(){
        var pokemon: MutableList<Pokemon> = MutableList(101){i->
            Pokemon(""+i, "name: "+i, "peso: "+i, "exp: "+i, "altura: " + i)
        }
        viewManager = LinearLayoutManager(this)
        viewAdapter = PokeAdapter(pokemon)

        recyclerPokemon.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }
}
