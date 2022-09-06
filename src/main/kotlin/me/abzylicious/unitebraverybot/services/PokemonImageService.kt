package me.abzylicious.unitebraverybot.services

import me.jakejmattson.discordkt.annotations.Service
import java.io.IOException
import java.net.URL
import javax.imageio.ImageIO

private object Constants {
    const val POKEMON_NAME_TEMPLATE = "%POKEMON_NAME%"
    const val POKEMON_TYPE_TEMPLATE = "%POKEMON_TYPE%"
    const val POKEMON_TYPE_NORMAL = "normal"
    const val POKEMON_IMAGE_URL = "https://img.pokemondb.net/sprites/home/$POKEMON_TYPE_TEMPLATE/$POKEMON_NAME_TEMPLATE.png"
}

private object SpecialPokemon {
    const val HOOPA = "Hoopa"
}

@Service
class PokemonImageService {
    fun getImage(name: String): String {
        val pokemonName = getPokemonName(name)
        val pokemonImageUrl = Constants.POKEMON_IMAGE_URL
            .replace(Constants.POKEMON_TYPE_TEMPLATE, Constants.POKEMON_TYPE_NORMAL)
            .replace(Constants.POKEMON_NAME_TEMPLATE, pokemonName)

        return if (isImage(pokemonImageUrl)) pokemonImageUrl else ""
    }

    private fun getPokemonName(pokemonName: String) = when {
        hasRegionalForm(pokemonName) -> handleRegionalForm(pokemonName)
        hasDot(pokemonName) -> handleDot(pokemonName)
        pokemonName == SpecialPokemon.HOOPA -> handleHoopa(pokemonName)
        else -> pokemonName.lowercase()
    }

    private fun hasDot(pokemonName: String) = pokemonName.contains('.') && pokemonName.contains(' ')
    private fun hasRegionalForm(pokemonName: String) = !pokemonName.contains('.') && pokemonName.contains(' ')

    private fun handleRegionalForm(pokemonName: String): String {
        val pokemonRegionAndName = pokemonName.lowercase().split(" ").zipWithNext().single()
        return "${pokemonRegionAndName.second}-${pokemonRegionAndName.first}"
    }

    private fun handleDot(pokemonName: String) = pokemonName.lowercase()
        .replace(" ", "")
        .replace('.', '-')

    private fun handleHoopa(pokemonName: String) = "${pokemonName.lowercase()}-confined"

    private fun isImage(url: String): Boolean {
        try {
            val imageUrl = URL(url)
            val image = ImageIO.read(imageUrl)
            return image != null
        } catch (exception: IOException) {
            return false
        }
    }
}
