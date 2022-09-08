package me.abzylicious.unitebraverybot.preconditions

import me.abzylicious.unitebraverybot.services.LoggingService
import me.jakejmattson.discordkt.dsl.precondition

@Suppress("unused")
fun commandLogger(loggingService: LoggingService) = precondition {
    command ?: return@precondition

    val guild = guild ?: return@precondition
    val commandName = command!!.name.lowercase()
    loggingService.log(guild, "${author.tag} :: ${author.id.value} invoked **$commandName** in ${channel.mention}")
    return@precondition
}
