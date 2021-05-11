package com.example.mvpdemo.data.source.remote.fetchJson

import com.example.mvpdemo.data.model.Pokemon
import com.example.mvpdemo.data.model.PokemonEntry
import org.json.JSONObject

class ParseJson {

    fun pokemonParseJson(jsonObject: JSONObject): Pokemon = jsonObject.run {
            val attacks = jsonObject.getJSONArray(PokemonEntry.ATTACKS)
            val images = getJSONObject(PokemonEntry.IMAGES)
            Pokemon(name = jsonObject.getString(PokemonEntry.NAME),
                types = jsonObject.getString(PokemonEntry.TYPES),
                hp = jsonObject.getString(PokemonEntry.HP),
                firstName = attacks.getJSONObject(0).getString(PokemonEntry.NAMEATTACK),
                firstDamage = attacks.getJSONObject(0).getString(PokemonEntry.DAMAGE) ,
                secondName = attacks.getJSONObject(1).getString(PokemonEntry.NAMEATTACK),
                secondDamage = attacks.getJSONObject(1).getString(PokemonEntry.DAMAGE) ,
                small = images.getString(PokemonEntry.SMALL))
    }
}
