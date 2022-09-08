package me.abzylicious.unitebraverybot.util

import me.abzylicious.unitebraverybot.dataclasses.Pokemon
import me.abzylicious.unitebraverybot.dataclasses.PokemonRole
import me.abzylicious.unitebraverybot.services.PokemonImageService
import me.jakejmattson.discordkt.annotations.Service
import org.jsoup.Jsoup
import org.jsoup.nodes.Element
import java.net.URL

private object Constants {
    const val BASE_URL = "https://unite.pokemon.com"
    const val POKEMON_ROSTER_URL = "$BASE_URL/en-us/pokemon"
    const val POKEMON_STYLESHEET_URL = "$BASE_URL/pokemon/pokemon.css"
    const val POKEMON_ROSTER_ID = "pokemon-list"
    const val POKEMON_NAME_CLASS = "pokemon-card__name"
    const val POKEMON_ROLE_NAME_ATTRIBUTE = "data-pokemon-battle-type"
    const val POKEMON_ROLE_ID_ATTRIBUTE = "data-role-id"
    const val BACKGROUND_COLOR_PREFIX = "--background-color:"
}

data class RoleColor(val id: Int, val color: String)

@Service
class PokemonScraper(private val pokemonImageService: PokemonImageService) {
    fun fetchAllPokemon(): List<Pokemon> {
        val document = Jsoup.connect(Constants.POKEMON_ROSTER_URL).get()
        val roster = document.getElementById(Constants.POKEMON_ROSTER_ID)
        val roleColors = fetchRoleColors()
        var result = mutableListOf<Pokemon>()
        roster?.children()?.forEach {
            val pokemon = buildPokemon(it, roleColors)
            result.add(pokemon)
        }

        return result
    }

    private fun buildPokemon(element: Element, roleColors: List<RoleColor>): Pokemon {
        val pokemonName = getPokemonName(element)
        return Pokemon(
            pokemonName,
            getPokemonRole(element, roleColors),
            pokemonImageService.getImage(pokemonName)
        )
    }

    private fun getPokemonName(element: Element) = element.getElementsByClass(Constants.POKEMON_NAME_CLASS).text()

    private fun getPokemonRole(element: Element, roleColors: List<RoleColor>): PokemonRole {
        val cardLink = element.firstChild()!!
        val role = cardLink.attr(Constants.POKEMON_ROLE_NAME_ATTRIBUTE)
        val roleId = cardLink.attr(Constants.POKEMON_ROLE_ID_ATTRIBUTE).toInt()
        val roleColor = roleColors.find { it.id == roleId }!!.color
        return PokemonRole(role, roleColor)
    }

    private fun fetchRoleColors() = URL(Constants.POKEMON_STYLESHEET_URL)
        .readText()
        .split("}")
        .filter { it.contains(Constants.POKEMON_ROLE_ID_ATTRIBUTE) }
        .map {
            val keyValuePair = it.replace(" ", "").split("{").zipWithNext().single()
            val roleId = keyValuePair.first.filter { dataIdChar -> dataIdChar.isDigit() }.toInt()
            val roleColor = keyValuePair.second.removePrefix(Constants.BACKGROUND_COLOR_PREFIX)
            RoleColor(roleId, roleColor)
        }
}