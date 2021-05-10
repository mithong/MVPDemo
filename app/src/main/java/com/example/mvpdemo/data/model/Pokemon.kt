package com.example.mvpdemo.data.model

data class Pokemon(
    val name : String = "",
    val types : String = "",
    val hp : String = "",
    val nameAttack : String = "",
    val damage : String = "",
    val nameAttack2 : String = "",
    val damage2 : String = "",
    val small : String = ""

)
object PokemonEntry {
    const val data = "data"
    const val name = "name"
    const val types = "types"
    const val hp = "hp"
    const val attacks = "attacks"
    const val nameAttack = "name"
    const val damage = "damage"
    const val images = "images"
    const val small = "small"
}
