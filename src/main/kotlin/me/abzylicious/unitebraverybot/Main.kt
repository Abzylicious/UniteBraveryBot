package me.abzylicious.unitebraverybot

import dev.kord.common.annotation.KordPreview
import dev.kord.common.entity.Permission
import dev.kord.common.entity.Permissions
import dev.kord.gateway.PrivilegedIntent
import me.abzylicious.unitebraverybot.dataclasses.Configuration
import me.abzylicious.unitebraverybot.embeds.createBotInformationEmbed
import me.abzylicious.unitebraverybot.locale.BotConstants
import me.abzylicious.unitebraverybot.locale.Messages
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
    }
}
