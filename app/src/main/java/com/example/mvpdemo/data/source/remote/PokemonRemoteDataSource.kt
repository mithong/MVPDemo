package com.example.mvpdemo.data.source.remote

import com.example.mvpdemo.data.model.Pokemon
import com.example.mvpdemo.data.model.PokemonEntry
import com.example.mvpdemo.data.source.PokemonDataSource
import com.example.mvpdemo.data.source.remote.fetchJson.GetJsonFromUrl
import com.example.mvpdemo.utils.Constant

class PokemonRemoteDataSource : PokemonDataSource.Remote{

    private var baseUrl = Constant.BASE_URL

    private object Holder {
        val INSTANCE = PokemonRemoteDataSource()
    }

    override fun getPokemon(listener: OnFetchDataJsonListener<MutableList<Pokemon>>) {
        GetJsonFromUrl(listener, PokemonEntry.data).execute(baseUrl)
    }

    companion object {
        val instance: PokemonRemoteDataSource by lazy { Holder.INSTANCE }
    }
}
