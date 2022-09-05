package me.abzylicious.unitebraverybot.conversations

import dev.kord.common.entity.Snowflake
import dev.kord.x.emoji.Emojis
import me.abzylicious.unitebraverybot.dataclasses.Configuration
import me.abzylicious.unitebraverybot.embeds.createConfigurationMessageEmbed
import me.abzylicious.unitebraverybot.locale.BotConstants
import me.abzylicious.unitebraverybot.locale.Labels
import me.abzylicious.unitebraverybot.locale.Messages
import me.jakejmattson.discordkt.arguments.ChannelArg
import me.jakejmattson.discordkt.arguments.EveryArg
import me.jakejmattson.discordkt.arguments.RoleArg
import me.jakejmattson.discordkt.conversations.ConversationBuilder
import me.jakejmattson.discordkt.conversations.conversation
import me.jakejmattson.discordkt.dsl.edit

class ConfigurationConversation(private val configuration: Configuration) {
    suspend fun createConfigurationConversation(guildId: Snowflake) = conversation {
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
            guildId,
            prefix,
            adminRole,
            loggingChannel,
            randomizeLane,
            randomizeHeldItems,
            randomizeBattleItems
        )
    }

    suspend fun createLaneRandomizationConfigurationConversation(guildId: Snowflake) = conversation {
        val randomizeLane = createConfigurationChoicePrompt(Labels.SETUP_RANDOMIZE_LANE_TITLE, Messages.SETUP_RANDOMIZE_LANE)

        configuration.edit {
            configuration[guildId]!!.randomizeLane = randomizeLane
        }
    }

    suspend fun createHeldItemsRandomizationConfigurationConversation(guildId: Snowflake) = conversation {
        val randomizeHeldItems = createConfigurationChoicePrompt(Labels.SETUP_RANDOMIZE_HELD_ITEMS_TITLE, Messages.SETUP_RANDOMIZE_HELD_ITEMS)

        configuration.edit {
            configuration[guildId]!!.randomizeHeldItems = randomizeHeldItems
        }
    }

    suspend fun createBattleItemsRandomizationConfigurationConversation(guildId: Snowflake) = conversation {
        val randomizeBattleItems = createConfigurationChoicePrompt(Labels.SETUP_RANDOMIZE_BATTLE_ITEMS_TITLE, Messages.SETUP_RANDOMIZE_BATTLE_ITEMS)

        configuration.edit {
            configuration[guildId]!!.randomizeBattleItems = randomizeBattleItems
        }
    }

    private suspend fun ConversationBuilder.createConfigurationChoicePrompt(title: String, description: String): Boolean = promptButton {
        embed {
            createConfigurationMessageEmbed(discord, title, description)
        }
        buttons {
            button(Labels.YES, Emojis.whiteCheckMark, true)
            button(Labels.NO, Emojis.x, false)
        }
    }
}
