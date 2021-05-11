package com.example.mvpdemo.utils

interface BasePresenter<T> {
    fun onStart()
    fun onStop()
    fun setView(view: T?)
}
