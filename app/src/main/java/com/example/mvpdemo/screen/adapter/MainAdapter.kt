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

class MainAdapter : RecyclerView.Adapter<MainAdapter.ViewHolder>(){
    private val pokemon = mutableListOf<Pokemon>()
    private lateinit var clickListener: (Pokemon) -> Unit

    fun updateData(pokemon: MutableList<Pokemon>?) {
        pokemon?.let {
            this.pokemon.clear()
            this.pokemon.addAll(it)
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

    override fun getItemCount() = pokemon.size

    override fun onBindViewHolder(holder: MainAdapter.ViewHolder, position: Int) = holder.bindViewData(pokemon[position])

    class ViewHolder(itemView: View?, private val onItemClicked: (Pokemon) -> Unit ) :
        RecyclerView.ViewHolder(itemView!!){

        @SuppressLint("SetTextI18n")
        fun bindViewData(pokemon : Pokemon) = with(itemView){
            pokemon.run {
                textViewName.text = name
                textViewType.text = resources.getString(R.string.Type) + types
                textViewHp.text = resources.getString(R.string.Hp) + hp
                textViewSkillOne.text = resources.getString(R.string.Skill) + firstName
                textViewDamageOne.text = resources.getString(R.string.Damage) + firstDamage
                textViewSkillTwo.text = resources.getString(R.string.Skill) + secondName
                textViewDamageTwo.text = resources.getString(R.string.Damage) + secondDamage
                setOnClickListener { onItemClicked(this) }
                getImage(this)
            }
        }

        private fun getImage(pokemon: Pokemon) {
            Glide.with(itemView.context)
                    .load(pokemon.small)
                    .into(itemView.imagePokemon)
        }
    }
}
