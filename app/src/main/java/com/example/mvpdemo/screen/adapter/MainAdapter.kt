package com.example.mvpdemo.screen.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvpdemo.R
import com.example.mvpdemo.data.model.Pokemon
import kotlinx.android.synthetic.main.item_layout.view.*

class MainAdapter : RecyclerView.Adapter<MainAdapter.ViewHolder?>(){

    private val pokemon = mutableListOf<Pokemon>()
    private lateinit var clickListener: (Pokemon) -> Unit

    fun updateData(pokemon: MutableList<Pokemon>?) {
        pokemon?.let {
            this.pokemon.clear()
            this.pokemon.addAll(pokemon)
            notifyDataSetChanged()
        }
    }

    fun registerItemRecyclerViewClickListener(onItemRecyclerViewClickListener: (Pokemon) -> Unit) {
        clickListener = onItemRecyclerViewClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)
        return ViewHolder(view, clickListener)
    }

    override fun getItemCount(): Int = pokemon.size

    override fun onBindViewHolder(holder: MainAdapter.ViewHolder, position: Int) =
        holder.bindViewData(pokemon[position])

    class ViewHolder(itemView: View?, private val onItemClicked: (Pokemon) -> Unit ) :
        RecyclerView.ViewHolder(itemView!!){
        @SuppressLint("SetTextI18n")
        fun bindViewData(pokemon : Pokemon) = with(itemView){
            tv_name.text = pokemon.name
            tv_type.text = "Type: "+pokemon.types
            tv_hp.text = "Hp: "+pokemon.hp
            tv_nameattack.text = "Skill: "+pokemon.nameAttack
            tv_damage.text = "Damage: "+pokemon.damage
            tv_nameattack2.text = "Skill: "+pokemon.nameAttack2
            tv_damage2.text = "Damage: "+pokemon.damage2
            setOnClickListener{onItemClicked(pokemon)}
            getImage(pokemon)
        }

        private fun getImage(pokemon: Pokemon) {
            Glide.with(itemView.context)
                .load(pokemon.small)
                .into(itemView.imgPoke)
        }

    }



}
