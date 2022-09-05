package me.abzylicious.unitebraverybot.commands

import me.abzylicious.unitebraverybot.embeds.createBraveryBuildEmbed
import me.abzylicious.unitebraverybot.locale.CommandDescriptions
import me.abzylicious.unitebraverybot.services.BraveryService
import me.jakejmattson.discordkt.commands.commands

@Suppress("unused")
fun braveryCommands(braveryService: BraveryService) = commands("Bravery") {
    text("roll") {
        description = CommandDescriptions.BRAVERY_ROLL
        execute {
            val invokedBy = author
            respondMenu {
                createBraveryBuildEmbed(invokedBy, guild.id, braveryService)
            }
        }
    }
}
