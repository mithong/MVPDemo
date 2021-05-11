package com.example.mvpdemo.data.model

data class Pokemon(
    val name : String = "",
    val types : String = "",
    val hp : String = "",
    val firstName : String = "",
    val firstDamage : String = "",
    val secondName : String = "",
    val secondDamage : String = "",
    val small : String = ""

)
object PokemonEntry {
    const val DATA = "data"
    const val NAME = "name"
    const val TYPES = "types"
    const val HP = "hp"
    const val ATTACKS = "attacks"
    const val NAMEATTACK = "name"
    const val DAMAGE = "damage"
    const val IMAGES = "images"
    const val SMALL = "small"
}
