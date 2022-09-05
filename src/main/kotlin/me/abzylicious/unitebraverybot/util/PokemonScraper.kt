package me.abzylicious.unitebraverybot.util

import me.abzylicious.unitebraverybot.dataclasses.Pokemon
import me.abzylicious.unitebraverybot.dataclasses.PokemonRole
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
    const val POKEMON_IMAGE_SELECTOR = ".pokemon-card__character > img"
    const val BACKGROUND_COLOR_PREFIX = "--background-color:"
}

data class RoleColor(val id: Int, val color: String)

class PokemonScraper {
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

    private fun buildPokemon(element: Element, roleColors: List<RoleColor>) = Pokemon(
        getPokemonName(element),
        getPokemonRole(element, roleColors),
        getPokemonImage(element)
    )

    private fun getPokemonName(element: Element) = element.getElementsByClass(Constants.POKEMON_NAME_CLASS).text()

    private fun getPokemonRole(element: Element, roleColors: List<RoleColor>): PokemonRole {
        val cardLink = element.firstChild()!!
        val role = cardLink.attr(Constants.POKEMON_ROLE_NAME_ATTRIBUTE)
        val roleId = cardLink.attr(Constants.POKEMON_ROLE_ID_ATTRIBUTE).toInt()
        val roleColor = roleColors.find { it.id == roleId }!!.color
        return PokemonRole(role, roleColor)
    }

    private fun getPokemonImage(element: Element) = element.select(Constants.POKEMON_IMAGE_SELECTOR)
        .attr("src")
        .replace("../..", Constants.BASE_URL)

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
