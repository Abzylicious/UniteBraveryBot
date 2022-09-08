package me.abzylicious.unitebraverybot.services

import me.abzylicious.unitebraverybot.util.timeToString
import me.jakejmattson.discordkt.Discord
import me.jakejmattson.discordkt.annotations.Service
import java.util.*

@Service
class BotStatisticsService(private val discord: Discord) {
    private var startTime: Date = Date()

    val uptime: String
        get() = timeToString(Date().time - startTime.time)

    val ping: String
        get() = "${discord.kord.gateway.averagePing}"
}
