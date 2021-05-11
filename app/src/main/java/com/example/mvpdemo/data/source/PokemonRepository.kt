package com.example.mvpdemo.data.source

import com.example.mvpdemo.data.model.Pokemon
import com.example.mvpdemo.data.source.local.PokemonLocalDataSource
import com.example.mvpdemo.data.source.remote.OnFetchDataJsonListener
import com.example.mvpdemo.data.source.remote.PokemonRemoteDataSource

class PokemonRepository private constructor(private val remote: PokemonDataSource.Remote,
                                            private val local: PokemonDataSource.Local) {

    fun getPokemon(listener: OnFetchDataJsonListener<MutableList<Pokemon>>) {
        remote.getPokemon(listener)
    }

    companion object {
        @Volatile
        private var instance: PokemonRepository? = null

        fun getRepository(
            remote: PokemonDataSource.Remote,
            local: PokemonDataSource.Local
        ): PokemonRepository =
                instance ?: synchronized(this) {
                val newInstance =
                        instance ?: PokemonRepository(remote, local).also { instance = it }
                newInstance
            }
    }
}
