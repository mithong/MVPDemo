package com.example.mvpdemo.screen

import com.example.mvpdemo.data.model.Pokemon
import com.example.mvpdemo.data.source.PokemonRepository
import com.example.mvpdemo.data.source.remote.OnFetchDataJsonListener

class MainPresenter internal constructor(private val repository: PokemonRepository?) : MainContract.Presenter {

    private var view: MainContract.View? = null

    override fun onStart() {
        getPokemon()
    }

    override fun onStop() {}

    override fun setView(view: MainContract.View?) {
        this.view = view
    }

    override fun getPokemon() {
        repository?.getPokemon(object : OnFetchDataJsonListener<MutableList<Pokemon>> {
            override fun onSuccess(data: MutableList<Pokemon>) {
                view?.onGetPokemonSuccess(data)
            }

            override fun onError(exception: Exception?) {
                view?.onError(exception)
            }
        })
    }
}
