package com.example.mvpdemo.data.source

import com.example.mvpdemo.data.model.Pokemon
import com.example.mvpdemo.data.source.remote.OnFetchDataJsonListener

interface PokemonDataSource {

    interface Local

    interface Remote{
        fun getPokemon(listener: OnFetchDataJsonListener<MutableList<Pokemon>>)
    }
}
