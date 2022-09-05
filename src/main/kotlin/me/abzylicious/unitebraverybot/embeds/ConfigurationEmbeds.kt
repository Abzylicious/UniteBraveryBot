package me.abzylicious.unitebraverybot.embeds

import dev.kord.core.entity.Guild
import dev.kord.rest.Image
import dev.kord.rest.builder.message.EmbedBuilder
import me.abzylicious.unitebraverybot.dataclasses.GuildConfiguration
import me.abzylicious.unitebraverybot.locale.Labels
import me.abzylicious.unitebraverybot.locale.Templates
import me.jakejmattson.discordkt.Discord
import me.jakejmattson.discordkt.extensions.addField
import me.jakejmattson.discordkt.extensions.addInlineField
import me.jakejmattson.discordkt.extensions.pfpUrl
import me.jakejmattson.discordkt.extensions.toSnowflake

suspend fun EmbedBuilder.createConfigurationMessageEmbed(discord: Discord, title: String, description: String) {
    val self = discord.kord.getSelf()
    color = discord.configuration.theme

    thumbnail {
        url = self.pfpUrl
    }

    this.title = title
    this.description = description
}

suspend fun EmbedBuilder.createConfigurationEmbed(discord: Discord, guild: Guild, guildConfiguration: GuildConfiguration) {
    color = discord.configuration.theme

    thumbnail {
        url = guild.getIconUrl(Image.Format.PNG) ?: ""
    }

    title = Labels.CONFIGURATION_TITLE.replace(Templates.GUILD_NAME, discord.kord.getGuild(guild.id)!!.name)
    addField(Labels.CONFIGURATION_PREFIX, guildConfiguration.prefix)
    addField(Labels.CONFIGURATION_ADMIN_ROLE, guild.getRole(guildConfiguration.adminRole.toSnowflake()).mention)
    addField(Labels.CONFIGURATION_LOGGING_CHANNEL, guild.getChannel(guildConfiguration.loggingChannel.toSnowflake()).mention)
    addInlineField(Labels.CONFIGURATION_LANE_RANDOMIZATION, if (guildConfiguration.randomizeLane) Labels.YES else Labels.NO)
    addInlineField(Labels.CONFIGURATION_HELD_ITEMS_RANDOMIZATION, if (guildConfiguration.randomizeHeldItems) Labels.YES else Labels.NO)
    addInlineField(Labels.CONFIGURATION_BATTLE_ITEM_RANDOMIZATION, if (guildConfiguration.randomizeBattleItems) Labels.YES else Labels.NO)
}
