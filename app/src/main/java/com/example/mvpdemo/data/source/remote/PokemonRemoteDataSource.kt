package com.example.mvpdemo.data.source.remote

import com.example.mvpdemo.data.model.Pokemon
import com.example.mvpdemo.data.model.PokemonEntry
import com.example.mvpdemo.data.source.PokemonDataSource
import com.example.mvpdemo.data.source.local.PokemonLocalDataSource
import com.example.mvpdemo.data.source.remote.fetchJson.GetJsonFromUrl
import com.example.mvpdemo.utils.Constant

class PokemonRemoteDataSource : PokemonDataSource.Remote{

    private val baseUrl = Constant.BASE_URL

    override fun getPokemon(listener: OnFetchDataJsonListener<MutableList<Pokemon>>) {
        GetJsonFromUrl(listener, PokemonEntry.DATA).execute(baseUrl)
    }

    companion object {
        @Volatile
        private var instance: PokemonRemoteDataSource? = null

        fun getRemote(): PokemonRemoteDataSource =
                instance ?: synchronized(this) {
                val newInstance =
                        instance ?: PokemonRemoteDataSource().also { instance = it }
                newInstance
            }
    }
}
