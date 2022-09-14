package me.abzylicious.unitebraverybot.dataclasses

import kotlinx.serialization.Serializable
import me.jakejmattson.discordkt.dsl.Data
import java.awt.Color

private object PokemonRole {
    const val SUPPORTER = "supporter"
    const val ALL_ROUNDER = "all-rounder"
    const val ATTACKER = "attacker"
    const val DEFENDER = "defender"
    const val SPEEDSTER = "speedster"
}

@Serializable
data class Pokemon(val name: String, val role: String, val firstMoveOptions: List<String>, val secondMoveOptions: List<String>) {
    fun getRoleColor(): Color = when (role) {
        PokemonRole.SUPPORTER -> Color.decode("#fecc51")
        PokemonRole.ALL_ROUNDER -> Color.decode("#ce5fd3")
        PokemonRole.ATTACKER -> Color.decode("#f16c38")
        PokemonRole.DEFENDER -> Color.decode("#aced5b")
        PokemonRole.SPEEDSTER -> Color.decode("#29a5e3")
        else -> Color.LIGHT_GRAY
    }
}

@Serializable
data class PokemonPool(val pokemon: List<Pokemon> = listOf()) : Data()
