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
                nameSkillOne = attacks.getJSONObject(0).getString(PokemonEntry.NAMEATTACK),
                damageSkillOne = attacks.getJSONObject(0).getString(PokemonEntry.DAMAGE) ,
                nameSkillTwo = attacks.getJSONObject(1).getString(PokemonEntry.NAMEATTACK),
                damageSkillTwo = attacks.getJSONObject(1).getString(PokemonEntry.DAMAGE) ,
                small = images.getString(PokemonEntry.SMALL))
    }
}
