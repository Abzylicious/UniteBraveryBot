package me.abzylicious.unitebraverybot.services

import me.abzylicious.unitebraverybot.dataclasses.Pokemon
import me.abzylicious.unitebraverybot.dataclasses.PokemonEntries
import me.abzylicious.unitebraverybot.util.PokemonScraper
import me.jakejmattson.discordkt.annotations.Service
import me.jakejmattson.discordkt.dsl.edit

@Service
class PokemonService(private val pokemonEntries: PokemonEntries) {
    fun scrapePokemon() = PokemonScraper().fetchAllPokemon()
    fun getPokemon() = pokemonEntries.pokemon

    fun updatePokemonList(pokemon: List<Pokemon>) {
        pokemon.forEach {
            if (!pokemonEntries.pokemon.contains(it))
                pokemonEntries.edit { this.pokemon.add(it) }
        }

        pokemonEntries.pokemon.forEach {
            if (!pokemon.contains(it))
                pokemonEntries.edit { this.pokemon.remove(it) }
        }
    }
}
