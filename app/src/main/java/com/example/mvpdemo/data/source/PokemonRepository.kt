package com.example.mvpdemo.data.source

import com.example.mvpdemo.data.model.Pokemon
import com.example.mvpdemo.data.source.local.PokemonLocalDataSource
import com.example.mvpdemo.data.source.remote.OnFetchDataJsonListener
import com.example.mvpdemo.data.source.remote.PokemonRemoteDataSource

class PokemonRepository private constructor(private val remote: PokemonDataSource.Remote,
                                            private val local: PokemonDataSource.Local) {

    private object Holder {
        val INSTANCE = PokemonRepository(
            remote = PokemonRemoteDataSource.instance,
            local = PokemonLocalDataSource.instance)
    }

    fun getPokemon(listener: OnFetchDataJsonListener<MutableList<Pokemon>>) {
        remote.getPokemon(listener)
    }

    companion object {
        val instance: PokemonRepository by lazy { Holder.INSTANCE }
    }

}
