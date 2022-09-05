package me.abzylicious.unitebraverybot.services

import dev.kord.core.behavior.getChannelOf
import dev.kord.core.entity.Guild
import dev.kord.core.entity.channel.TextChannel
import me.abzylicious.unitebraverybot.dataclasses.Configuration
import me.jakejmattson.discordkt.Discord
import me.jakejmattson.discordkt.annotations.Service
import me.jakejmattson.discordkt.extensions.toSnowflake

@Service
class LoggingService(private val configuration: Configuration, private val discord: Discord) {
    suspend fun log(guild: Guild, message: String) = getLoggingChannel(guild)?.createMessage(message)
    suspend fun logToAllGuilds(message: String) = configuration.guildConfigurations.forEach { log(it.value.loggingChannel, message) }
    private suspend fun log(channelId: String, message: String) = getLoggingChannel(channelId)?.createMessage(message)

    private suspend fun getLoggingChannel(guild: Guild): TextChannel? {
        val loggingChannel = configuration[guild.id]?.loggingChannel ?: return null
        val channelId = loggingChannel.takeIf { it.isNotEmpty() } ?: return null
        return guild.getChannelOf(channelId.toSnowflake())
    }

    private suspend fun getLoggingChannel(channelId: String) = discord.kord.getChannelOf<TextChannel>(channelId.toSnowflake())
}
