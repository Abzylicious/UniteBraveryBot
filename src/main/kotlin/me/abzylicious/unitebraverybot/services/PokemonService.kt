package me.abzylicious.unitebraverybot.services

import me.abzylicious.unitebraverybot.dataclasses.Pokemon
import me.abzylicious.unitebraverybot.dataclasses.PokemonEntries
import me.jakejmattson.discordkt.annotations.Service
import me.jakejmattson.discordkt.dsl.edit

@Service
class PokemonService(private val pokemonEntries: PokemonEntries) {
    fun getPokemon() = pokemonEntries.pokemon

    fun updatePokemonList(currentPokemon: List<Pokemon>) {
        pokemonEntries.edit {
            pokemon.removeIf { !currentPokemon.contains(it) }

            currentPokemon.forEach {
                if (!pokemon.contains(it))
                    pokemon.add(it)
            }
        }
    }
}
