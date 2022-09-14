package me.abzylicious.unitebraverybot.commands

import dev.kord.common.entity.Permission
import dev.kord.common.entity.Permissions
import me.abzylicious.unitebraverybot.conversations.RandomizerConfigurationConversation
import me.abzylicious.unitebraverybot.dataclasses.Configuration
import me.abzylicious.unitebraverybot.locale.CommandDescriptions
import me.abzylicious.unitebraverybot.locale.Messages
import me.jakejmattson.discordkt.commands.subcommand

@Suppress("unused")
fun randomizerConfigurationCommands(configuration: Configuration) = subcommand("randomizer", Permissions(Permission.Administrator)) {
    sub("lane", CommandDescriptions.RANDOMIZER_LANE_RANDOMIZATION) {
        execute {
            if (!configuration.hasGuildConfiguration(guild.id)) {
                respond(Messages.GUILD_CONFIGURATION_NOT_FOUND)
                return@execute
            }

            RandomizerConfigurationConversation(configuration)
                .createLaneRandomizationConfigurationConversation(guild.id)
                .startSlashResponse(discord, author, this)
        }
    }

    sub("helditems", CommandDescriptions.RANDOMIZER_HELD_ITEMS_RANDOMIZATION) {
        execute {
            if (!configuration.hasGuildConfiguration(guild.id)) {
                respond(Messages.GUILD_CONFIGURATION_NOT_FOUND)
                return@execute
            }

            RandomizerConfigurationConversation(configuration)
                .createHeldItemsRandomizationConfigurationConversation(guild.id)
                .startSlashResponse(discord, author, this)
        }
    }

    sub("battleitem", CommandDescriptions.RANDOMIZER_BATTLE_ITEM_RANDOMIZATION) {
        execute {
            if (!configuration.hasGuildConfiguration(guild.id)) {
                respond(Messages.GUILD_CONFIGURATION_NOT_FOUND)
                return@execute
            }

            RandomizerConfigurationConversation(configuration)
                .createBattleItemsRandomizationConfigurationConversation(guild.id)
                .startSlashResponse(discord, author, this)
        }
    }
    sub("moves", CommandDescriptions.RANDOMIZER_MOVES_RANDOMIZATION) {
        execute {
            if (!configuration.hasGuildConfiguration(guild.id)) {
                respond(Messages.GUILD_CONFIGURATION_NOT_FOUND)
                return@execute
            }

            RandomizerConfigurationConversation(configuration)
                .createMovesRandomizationConfigurationConversation(guild.id)
                .startSlashResponse(discord, author, this)
        }
    }
}
