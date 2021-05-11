package com.example.mvpdemo.screen

import com.example.mvpdemo.data.model.Pokemon
import com.example.mvpdemo.utils.BasePresenter

interface MainContract {
    /**
     * View
     */
    interface View {
        fun onGetPokemonSuccess(pokemon: MutableList<Pokemon>)
        fun onError(exception: Exception?)
    }

    /**
     * Presenter
     */
    interface Presenter : BasePresenter<View> {
        fun getPokemon()
    }
}
