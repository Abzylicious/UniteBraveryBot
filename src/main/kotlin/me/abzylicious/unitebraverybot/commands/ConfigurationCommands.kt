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
import me.jakejmattson.discordkt.commands.subcommand
import me.jakejmattson.discordkt.dsl.edit

@Suppress("unused")
fun configurationCommands(configuration: Configuration) = subcommand("configuration", Permissions(Permission.Administrator)) {
    sub("show", CommandDescriptions.CONFIGURATION_SHOW) {
        execute {
            if (!configuration.hasGuildConfiguration(guild.id)) {
                respond(Messages.GUILD_CONFIGURATION_NOT_FOUND)
                return@execute
            }

            val guildConfiguration = configuration[guild.id]!!
            respond { createConfigurationEmbed(discord, guild, guildConfiguration) }
        }
    }

    sub("setup", CommandDescriptions.CONFIGURATION_SETUP) {
        execute {
            if (configuration.hasGuildConfiguration(guild.id)) {
                respond(Messages.GUILD_CONFIGURATION_EXISTS)
                return@execute
            }

            ConfigurationConversation(configuration)
                .createConfigurationConversation(guild)
                .startSlashResponse(discord, author, this)
        }
    }

    sub("prefix", CommandDescriptions.CONFIGURATION_PREFIX) {
        execute(EveryArg("Prefix")) {
            if (!configuration.hasGuildConfiguration(guild.id)) {
                respond(Messages.GUILD_CONFIGURATION_NOT_FOUND)
                return@execute
            }

            val prefix = args.first
            configuration.edit {
                configuration[guild.id]!!.prefix = prefix
            }
            respond(Messages.CONFIGURATION_SET_PREFIX.replace(Templates.PREFIX, prefix))
        }
    }

    sub("adminrole", CommandDescriptions.CONFIGURATION_ADMIN_ROLE) {
        execute(RoleArg("AdminRole")) {
            if (!configuration.hasGuildConfiguration(guild.id)) {
                respond(Messages.GUILD_CONFIGURATION_NOT_FOUND)
                return@execute
            }

            val role = args.first
            configuration.edit {
                configuration[guild.id]!!.adminRole = role.id.value.toString()
            }
            respond(Messages.CONFIGURATION_SET_ADMIN_ROLE.replace(Templates.ROLE, role.name))
        }
    }

    sub("loggingchannel", CommandDescriptions.CONFIGURATION_LOGGING_CHANNEL) {
        execute(ChannelArg("LoggingChannel")) {
            if (!configuration.hasGuildConfiguration(guild.id)) {
                respond(Messages.GUILD_CONFIGURATION_NOT_FOUND)
                return@execute
            }

            val channel = args.first
            configuration.edit {
                configuration[guild.id]!!.loggingChannel = channel.id.value.toString()
            }
            respond(Messages.CONFIGURATION_SET_LOGGING_CHANNEL.replace(Templates.CHANNEL, channel.name))
        }
    }
}
