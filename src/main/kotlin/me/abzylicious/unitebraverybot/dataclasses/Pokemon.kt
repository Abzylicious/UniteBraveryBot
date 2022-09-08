package me.abzylicious.unitebraverybot.dataclasses

import kotlinx.serialization.Serializable
import me.jakejmattson.discordkt.dsl.Data

@Serializable
data class PokemonRole(val name: String, val color: String)

@Serializable
data class Pokemon(val name: String, val role: PokemonRole, val imageUrl: String)

@Serializable
data class PokemonEntries(val pokemon: MutableList<Pokemon> = mutableListOf()) : Data()
