package me.abzylicious.unitebraverybot.commands

import dev.kord.core.behavior.interaction.response.respond
import me.abzylicious.unitebraverybot.embeds.createBraveryBuildEmbed
import me.abzylicious.unitebraverybot.locale.CommandDescriptions
import me.abzylicious.unitebraverybot.locale.Messages
import me.abzylicious.unitebraverybot.services.BraveryService
import me.abzylicious.unitebraverybot.services.PokemonImageService
import me.jakejmattson.discordkt.commands.commands
import me.jakejmattson.discordkt.extensions.createMenu

@Suppress("unused")
fun braveryCommands(braveryService: BraveryService, pokemonImageService: PokemonImageService) = commands("Bravery") {
    slash("build", CommandDescriptions.BRAVERY_ROLL) {
        execute {
            val invokedBy = author
            val interactionResponse = interaction?.deferPublicResponse()
            channel.createMenu { createBraveryBuildEmbed(invokedBy, guild.id, braveryService, pokemonImageService) }
            interactionResponse?.respond { content = Messages.BRAVERY_BUILD_RESULT }
        }
    }
}
