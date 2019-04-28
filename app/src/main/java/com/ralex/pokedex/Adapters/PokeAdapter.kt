package com.ralex.pokedex.Adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ralex.pokedex.Utils.Pokemon
import com.ralex.pokedex.R
import kotlinx.android.synthetic.main.pokebase.view.*

class PokeAdapter(val pokeList: List<Pokemon>): RecyclerView.Adapter<PokeAdapter.ViewHolder>(){


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(p0.context)
                .inflate(R.layout.pokebase, p0, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return pokeList.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.bind(pokeList[p1])
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(elemento: Pokemon) = with(itemView){
            pokeId.text = elemento.id
            pokeName.text = elemento.name
            pokeExp.text = elemento.baseExp
            pokeHeight.text = elemento.height
            pokeWeight.text = elemento.weight

        }
    }
}