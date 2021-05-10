package com.example.mvpdemo.data.source.remote.fetchJson

import com.example.mvpdemo.data.model.Pokemon
import com.example.mvpdemo.data.model.PokemonEntry
import org.json.JSONObject

class ParseJson {

    fun pokemonParseJson(jsonObject: JSONObject): Pokemon =
        jsonObject.run {

            val attacks = jsonObject.getJSONArray(PokemonEntry.attacks)
            val images = getJSONObject(PokemonEntry.images)

            Pokemon(name = jsonObject.getString(PokemonEntry.name),
                types = jsonObject.getString(PokemonEntry.types),
                hp = jsonObject.getString(PokemonEntry.hp),
                nameAttack = attacks.getJSONObject(0).getString(PokemonEntry.nameAttack),
                damage = attacks.getJSONObject(0).getString(PokemonEntry.damage) ,
                nameAttack2 = attacks.getJSONObject(1).getString(PokemonEntry.nameAttack),
                damage2 = attacks.getJSONObject(1).getString(PokemonEntry.damage) ,
                small = images.getString(PokemonEntry.small))
    }

}
