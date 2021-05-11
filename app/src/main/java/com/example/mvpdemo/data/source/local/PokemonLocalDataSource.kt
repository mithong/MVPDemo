package com.example.mvpdemo.data.source.local

import com.example.mvpdemo.data.source.PokemonDataSource

class PokemonLocalDataSource : PokemonDataSource, PokemonDataSource.Local {

    companion object {
        @Volatile
        private var mInstance: PokemonLocalDataSource? = null

        fun getLocal(): PokemonLocalDataSource =
            mInstance ?: synchronized(this) {
                val newInstance =
                    mInstance ?: PokemonLocalDataSource().also { mInstance = it }
                newInstance
            }
    }
}
