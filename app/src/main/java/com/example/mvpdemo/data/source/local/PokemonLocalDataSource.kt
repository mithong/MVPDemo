package com.example.mvpdemo.data.source.local

import com.example.mvpdemo.data.source.PokemonDataSource

class PokemonLocalDataSource : PokemonDataSource, PokemonDataSource.Local {

    companion object {
        @Volatile
        private var instance: PokemonLocalDataSource? = null

        fun getLocal(): PokemonLocalDataSource =
                instance ?: synchronized(this) {
                val newInstance =
                        instance ?: PokemonLocalDataSource().also { instance = it }
                newInstance
            }
    }
}
