package me.abzylicious.unitebraverybot.commands

import dev.kord.common.entity.Permission
import dev.kord.common.entity.Permissions
import me.abzylicious.unitebraverybot.conversations.ConfigurationConversation
import me.abzylicious.unitebraverybot.dataclasses.Configuration
import me.abzylicious.unitebraverybot.embeds.createConfigurationEmbed
import me.abzylicious.unitebraverybot.locale.CommandDescriptions
import me.abzylicious.unitebraverybot.locale.Messages
import me.abzylicious.unitebraverybot.locale.Templates
import me.jakejmattson.discordkt.arguments.ChannelArg
import me.jakejmattson.discordkt.arguments.EveryArg
import me.jakejmattson.discordkt.arguments.RoleArg
import me.jakejmattson.discordkt.commands.commands
import me.jakejmattson.discordkt.dsl.edit

@Suppress("unused")
fun configurationCommands(configuration: Configuration) = commands("Configuration") {
    text("configuration") {
        description = CommandDescriptions.CONFIGURATION_CONFIGURATION
        requiredPermissions = Permissions(Permission.Administrator)
        execute {
            val guildId = guild.id
            if (!configuration.hasGuildConfiguration(guildId)) {
                respond(Messages.GUILD_CONFIGURATION_NOT_FOUND)
                return@execute
            }

            val guildConfiguration = configuration[guildId]!!
            respond { createConfigurationEmbed(discord, guild, guildConfiguration) }
        }
    }

    text("configure") {
        description = CommandDescriptions.CONFIGURATION_CONFIGURE
        requiredPermissions = Permissions(Permission.Administrator)
        execute {
            val guildId = guild.id
            if (configuration.hasGuildConfiguration(guildId)) {
                respond(Messages.GUILD_CONFIGURATION_EXISTS)
                return@execute
            }

            ConfigurationConversation(configuration)
                .createConfigurationConversation(guildId)
                .startPublicly(discord, author, channel)

            respond(Messages.SETUP_COMPLETE.replace(Templates.GUILD_NAME, guild.name))
        }
    }

    text("setprefix") {
        description = CommandDescriptions.CONFIGURATION_SET_PREFIX
        requiredPermissions = Permissions(Permission.Administrator)
        execute(EveryArg) {
            val guildId = guild.id
            if (!configuration.hasGuildConfiguration(guildId)) {
                respond(Messages.GUILD_CONFIGURATION_NOT_FOUND)
                return@execute
            }

            val prefix = args.first
            configuration.edit {
                configuration[guildId]!!.prefix = prefix
            }
            respond(Messages.CONFIGURATION_SET_PREFIX.replace(Templates.PREFIX, prefix))
        }
    }

    text("setadminrole") {
        description = CommandDescriptions.CONFIGURATION_SET_ADMIN_ROLE
        requiredPermissions = Permissions(Permission.Administrator)
        execute(RoleArg) {
            val guildId = guild.id
            if (!configuration.hasGuildConfiguration(guildId)) {
                respond(Messages.GUILD_CONFIGURATION_NOT_FOUND)
                return@execute
            }

            val role = args.first
            configuration.edit {
                configuration[guildId]!!.adminRole = role.id.value.toString()
            }
            respond(Messages.CONFIGURATION_SET_ADMIN_ROLE.replace(Templates.ROLE, role.name))
        }
    }

    text("setloggingchannel") {
        description = CommandDescriptions.CONFIGURATION_SET_LOGGING_CHANNEL
        requiredPermissions = Permissions(Permission.Administrator)
        execute(ChannelArg) {
            val guildId = guild.id
            if (!configuration.hasGuildConfiguration(guildId)) {
                respond(Messages.GUILD_CONFIGURATION_NOT_FOUND)
                return@execute
            }

            val channel = args.first
            configuration.edit {
                configuration[guildId]!!.loggingChannel = channel.id.value.toString()
            }
            respond(Messages.CONFIGURATION_SET_LOGGING_CHANNEL.replace(Templates.ROLE, channel.name))
        }
    }

    text("setlanerandomization") {
        description = CommandDescriptions.CONFIGURATION_SET_LANE_RANDOMIZATION
        requiredPermissions = Permissions(Permission.Administrator)
        execute {
            val guildId = guild.id
            if (!configuration.hasGuildConfiguration(guildId)) {
                respond(Messages.GUILD_CONFIGURATION_NOT_FOUND)
                return@execute
            }

            ConfigurationConversation(configuration)
                .createLaneRandomizationConfigurationConversation(guildId)
                .startPublicly(discord, author, channel)

            respond(Messages.CONFIGURATION_SET_LANE_RANDOMIZATION)
        }
    }

    text("sethelditemsrandomization") {
        description = CommandDescriptions.CONFIGURATION_SET_HELD_ITEMS_RANDOMIZATION
        requiredPermissions = Permissions(Permission.Administrator)
        execute {
            val guildId = guild.id
            if (!configuration.hasGuildConfiguration(guildId)) {
                respond(Messages.GUILD_CONFIGURATION_NOT_FOUND)
                return@execute
            }

            ConfigurationConversation(configuration)
                .createHeldItemsRandomizationConfigurationConversation(guildId)
                .startPublicly(discord, author, channel)

            respond(Messages.CONFIGURATION_SET_HELD_ITEMS_RANDOMIZATION)
        }
    }

    text("setbattleitemrandomization") {
        description = CommandDescriptions.CONFIGURATION_SET_BATTLE_ITEM_RANDOMIZATION
        requiredPermissions = Permissions(Permission.Administrator)
        execute {
            val guildId = guild.id
            if (!configuration.hasGuildConfiguration(guildId)) {
                respond(Messages.GUILD_CONFIGURATION_NOT_FOUND)
                return@execute
            }

            ConfigurationConversation(configuration)
                .createBattleItemsRandomizationConfigurationConversation(guildId)
                .startPublicly(discord, author, channel)

            respond(Messages.CONFIGURATION_SET_BATTLE_ITEM_RANDOMIZATION)
        }
    }
}
