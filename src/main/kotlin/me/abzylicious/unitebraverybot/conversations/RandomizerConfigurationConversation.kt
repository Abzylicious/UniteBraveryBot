package me.abzylicious.unitebraverybot.conversations

import dev.kord.common.entity.Snowflake
import me.abzylicious.unitebraverybot.dataclasses.Configuration
import me.abzylicious.unitebraverybot.extensions.discordkt.createConfigurationChoicePrompt
import me.abzylicious.unitebraverybot.locale.BotConstants
import me.abzylicious.unitebraverybot.locale.Labels
import me.abzylicious.unitebraverybot.locale.Messages
import me.abzylicious.unitebraverybot.locale.Templates
import me.jakejmattson.discordkt.conversations.slashConversation
import me.jakejmattson.discordkt.dsl.edit

class RandomizerConfigurationConversation(private val configuration: Configuration) {
    suspend fun createLaneRandomizationConfigurationConversation(guildId: Snowflake) = slashConversation(BotConstants.CONVERSATION_EXIT_COMMAND) {
        val randomizeLane = createConfigurationChoicePrompt(Labels.SETUP_RANDOMIZE_LANE_TITLE, Messages.SETUP_RANDOMIZE_LANE)

        configuration.edit {
            configuration[guildId]!!.randomizeLane = randomizeLane
        }

        respond(createConfigurationChoicePromptSuccessMessage(Messages.CONFIGURATION_SET_LANE_RANDOMIZATION, randomizeLane))
    }

    suspend fun createHeldItemsRandomizationConfigurationConversation(guildId: Snowflake) = slashConversation(BotConstants.CONVERSATION_EXIT_COMMAND) {
        val randomizeHeldItems = createConfigurationChoicePrompt(Labels.SETUP_RANDOMIZE_HELD_ITEMS_TITLE, Messages.SETUP_RANDOMIZE_HELD_ITEMS)

        configuration.edit {
            configuration[guildId]!!.randomizeHeldItems = randomizeHeldItems
        }

        respond(createConfigurationChoicePromptSuccessMessage(Messages.CONFIGURATION_SET_HELD_ITEMS_RANDOMIZATION, randomizeHeldItems))
    }

    suspend fun createBattleItemsRandomizationConfigurationConversation(guildId: Snowflake) = slashConversation(BotConstants.CONVERSATION_EXIT_COMMAND) {
        val randomizeBattleItems = createConfigurationChoicePrompt(Labels.SETUP_RANDOMIZE_BATTLE_ITEMS_TITLE, Messages.SETUP_RANDOMIZE_BATTLE_ITEMS)

        configuration.edit {
            configuration[guildId]!!.randomizeBattleItems = randomizeBattleItems
        }

        respond(createConfigurationChoicePromptSuccessMessage(Messages.CONFIGURATION_SET_BATTLE_ITEM_RANDOMIZATION, randomizeBattleItems))
    }

    private fun createConfigurationChoicePromptSuccessMessage(message: String, choice: Boolean): String {
        val choiceText = if (choice) Labels.ENABLED else Labels.DISABLED
        return message.replace(Templates.CHOICE, choiceText)
    }
}
