package me.abzylicious.unitebraverybot.embeds

import dev.kord.common.entity.Snowflake
import dev.kord.common.kColor
import dev.kord.core.entity.User
import dev.kord.rest.builder.message.EmbedBuilder
import dev.kord.x.emoji.Emojis
import me.abzylicious.unitebraverybot.dataclasses.BraveryBuild
import me.abzylicious.unitebraverybot.locale.Labels
import me.abzylicious.unitebraverybot.locale.Templates
import me.abzylicious.unitebraverybot.services.BraveryService
import me.jakejmattson.discordkt.dsl.MenuBuilder
import me.jakejmattson.discordkt.extensions.addField
import me.jakejmattson.discordkt.extensions.fullName
import me.jakejmattson.discordkt.extensions.pfpUrl

suspend fun MenuBuilder.createBraveryBuildEmbed(author: User, guildId: Snowflake, braveryService: BraveryService) {
    val braveryBuild = braveryService.getBraveryBuild(guildId)
    page {
        createBraveryBuildEmbed(author, braveryBuild)
    }
    buttons {
        editButton(Labels.BRAVERY_BUILD_REROLL, Emojis.gameDie) {
            fields.clear()
            val newBraveryBuild = braveryService.getBraveryBuild(guildId)
            createBraveryBuildEmbed(author, newBraveryBuild)
        }
    }
}

private fun EmbedBuilder.createBraveryBuildEmbed(author: User, braveryBuild: BraveryBuild) {
    val decodedColor = java.awt.Color.decode(braveryBuild.pokemon.role.color)
    color = decodedColor.kColor

    author {
        name = author.fullName
        icon = author.pfpUrl
    }

    thumbnail {
        url = braveryBuild.pokemon.imageUrl
    }

    title = Labels.BRAVERY_BUILD_TITLE
    description = Labels.BRAVERY_BUILD_DESCRIPTION.replace(Templates.POKEMON, braveryBuild.pokemon.name)

    if (braveryBuild.lane != null)
        addField(Labels.BRAVERY_BUILD_LANE, braveryBuild.lane.laneName)

    if (braveryBuild.heldItems != null)
        addField(Labels.BRAVERY_BUILD_HELD_ITEMS, "${braveryBuild.heldItems[0].item}\n${braveryBuild.heldItems[1].item}\n${braveryBuild.heldItems[2].item}")

    if (braveryBuild.battleItem != null)
        addField(Labels.BRAVERY_BUILD_BATTLE_ITEMS, braveryBuild.battleItem.item)
}