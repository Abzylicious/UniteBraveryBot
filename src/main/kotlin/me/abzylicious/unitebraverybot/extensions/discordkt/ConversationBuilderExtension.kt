package me.abzylicious.unitebraverybot.extensions.discordkt

import dev.kord.x.emoji.Emojis
import me.abzylicious.unitebraverybot.embeds.createConfigurationMessageEmbed
import me.abzylicious.unitebraverybot.locale.Labels
import me.jakejmattson.discordkt.conversations.ConversationBuilder

suspend fun ConversationBuilder.createConfigurationChoicePrompt(title: String, description: String): Boolean = promptButton {
    embed {
        createConfigurationMessageEmbed(discord, title, description)
    }
    buttons {
        button(Labels.YES, Emojis.whiteCheckMark, true)
        button(Labels.NO, Emojis.x, false)
    }
}
