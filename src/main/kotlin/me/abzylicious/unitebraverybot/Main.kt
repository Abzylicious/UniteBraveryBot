package me.abzylicious.unitebraverybot

import dev.kord.common.annotation.KordPreview
import dev.kord.common.entity.Permission
import dev.kord.common.entity.Permissions
import dev.kord.gateway.PrivilegedIntent
import me.abzylicious.unitebraverybot.dataclasses.Configuration
import me.abzylicious.unitebraverybot.dataclasses.PokemonEntries
import me.abzylicious.unitebraverybot.embeds.createBotInformationEmbed
import me.abzylicious.unitebraverybot.locale.BotConstants
import me.abzylicious.unitebraverybot.locale.Messages
import me.abzylicious.unitebraverybot.locale.Templates
import me.abzylicious.unitebraverybot.services.LoggingService
import me.abzylicious.unitebraverybot.services.PokemonService
import me.jakejmattson.discordkt.dsl.bot
import java.awt.Color
import java.lang.System.getenv

@KordPreview
@PrivilegedIntent
fun main(args: Array<String>) {
    val token = args.firstOrNull()
        ?: getenv(BotConstants.BOT_TOKEN)
        ?: null

    require(token != null) { Messages.NO_TOKEN_PROVIDED }

    bot(token) {
        val defaultPrefix = getenv(BotConstants.DEFAULT_PREFIX) ?: BotConstants.DEFAULT_PREFIX_VALUE
        val configuration = data(BotConstants.CONFIGURATION_DATA_PATH) { Configuration() }
        data(BotConstants.POKEMON_DATA_PATH) { PokemonEntries() }

        prefix {
            guild?.let { configuration[it.id]?.prefix } ?: defaultPrefix
        }

        configure {
            mentionAsPrefix = true
            commandReaction = null
            logStartup = true
            deleteInvocation = false
            dualRegistry = true
            theme = Color(255, 119, 15)
            defaultPermissions = Permissions(Permission.UseApplicationCommands, Permission.UseEmbeddedActivities)
        }

        mentionEmbed {
            createBotInformationEmbed(it)
        }

        presence {
            playing(BotConstants.PRESENCE_PLAYING)
        }

        onStart {
            val logger = this.getInjectionObjects(LoggingService::class)
            logger.logToAllGuilds(Messages.STARTUP_LOG)
            val pokemonService = getInjectionObjects(PokemonService::class)
            val pokemonCount = pokemonService.getPokemon().size
            logger.logToAllGuilds(Messages.POKEMON_ROSTER_LOG.replace(Templates.POKEMON_COUNT, pokemonCount.toString()))
        }
    }
}
