package me.abzylicious.unitebraverybot.commands

import me.abzylicious.unitebraverybot.locale.CommandDescriptions
import me.jakejmattson.discordkt.commands.commands

@Suppress("unused")
fun utilityCommands() = commands("Utility") {
    slash("Ping", CommandDescriptions.UTILITY_PING) {
        execute {
            respond("Pong! (${discord.kord.gateway.averagePing})")
        }
    }
}
