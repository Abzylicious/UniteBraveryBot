package me.abzylicious.unitebraverybot.conversations

import dev.kord.core.entity.Guild
import me.abzylicious.unitebraverybot.dataclasses.Configuration
import me.abzylicious.unitebraverybot.embeds.createConfigurationMessageEmbed
import me.abzylicious.unitebraverybot.extensions.discordkt.createConfigurationChoicePrompt
import me.abzylicious.unitebraverybot.locale.BotConstants
import me.abzylicious.unitebraverybot.locale.Labels
import me.abzylicious.unitebraverybot.locale.Messages
import me.abzylicious.unitebraverybot.locale.Templates
import me.jakejmattson.discordkt.arguments.ChannelArg
import me.jakejmattson.discordkt.arguments.EveryArg
import me.jakejmattson.discordkt.arguments.RoleArg
import me.jakejmattson.discordkt.conversations.slashConversation

class ConfigurationConversation(private val configuration: Configuration) {
    suspend fun createConfigurationConversation(guild: Guild) = slashConversation(BotConstants.CONVERSATION_EXIT_COMMAND) {
        val setPrefix = createConfigurationChoicePrompt(Labels.SETUP_PREFIX_TITLE, Messages.SETUP_PREFIX_DECISION)
        val prefix = if (setPrefix) {
            prompt(EveryArg) {
                createConfigurationMessageEmbed(discord, Labels.SETUP_PREFIX_TITLE, Messages.SETUP_PREFIX)
            }
        } else BotConstants.DEFAULT_PREFIX_VALUE

        val adminRole = prompt(RoleArg) {
            createConfigurationMessageEmbed(discord, Labels.SETUP_ADMIN_ROLE_TITLE, Messages.SETUP_ADMIN_ROLE)
        }

        val loggingChannel = prompt(ChannelArg) {
            createConfigurationMessageEmbed(discord, Labels.SETUP_LOGGING_CHANNEL_TITLE, Messages.SETUP_LOGGING_CHANNEL)
        }

        val randomizeLane = createConfigurationChoicePrompt(Labels.SETUP_RANDOMIZE_LANE_TITLE, Messages.SETUP_RANDOMIZE_LANE)
        val randomizeHeldItems = createConfigurationChoicePrompt(Labels.SETUP_RANDOMIZE_HELD_ITEMS_TITLE, Messages.SETUP_RANDOMIZE_HELD_ITEMS)
        val randomizeBattleItems = createConfigurationChoicePrompt(Labels.SETUP_RANDOMIZE_BATTLE_ITEMS_TITLE, Messages.SETUP_RANDOMIZE_BATTLE_ITEMS)

        configuration.setup(
            guild.id,
            prefix,
            adminRole,
            loggingChannel,
            randomizeLane,
            randomizeHeldItems,
            randomizeBattleItems
        )

        respond(Messages.SETUP_COMPLETE.replace(Templates.GUILD_NAME, guild.name))
    }
}
