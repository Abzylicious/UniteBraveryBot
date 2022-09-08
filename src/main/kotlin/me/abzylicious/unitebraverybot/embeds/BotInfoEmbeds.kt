package me.abzylicious.unitebraverybot.embeds

import dev.kord.rest.builder.message.EmbedBuilder
import me.abzylicious.unitebraverybot.services.BotStatisticsService
import me.jakejmattson.discordkt.commands.DiscordContext
import me.jakejmattson.discordkt.extensions.addInlineField
import me.jakejmattson.discordkt.extensions.pfpUrl

suspend fun EmbedBuilder.createBotInformationEmbed(discordContext: DiscordContext) {
    val botStatisticsService = discordContext.discord.getInjectionObjects(BotStatisticsService::class)
    val channel = discordContext.channel
    val self = channel.kord.getSelf()
    val properties = discordContext.discord.properties.bot
    color = discordContext.discord.configuration.theme

    thumbnail {
        url = self.pfpUrl
    }

    field {
        name = self.tag
        value = properties.description!!
    }

    addInlineField("Prefix", discordContext.prefix())
    addInlineField("Ping", botStatisticsService.ping)
    addInlineField("Contributors", "[Link](${properties.url}/graphs/contributors)")

    val kotlinVersion = KotlinVersion.CURRENT
    val versions = discordContext.discord.properties.library
    field {
        name = "Build Info"
        value = "```" +
                "Version: ${properties.version}\n" +
                "DiscordKt: ${versions.version}\n" +
                "Kord: ${versions.kord}\n" +
                "Kotlin: $kotlinVersion" +
                "```"
    }
    field {
        name = "Uptime"
        value = botStatisticsService.uptime
    }
    field {
        name = "Source"
        value = "[GitHub](${properties.url})"
    }
}
