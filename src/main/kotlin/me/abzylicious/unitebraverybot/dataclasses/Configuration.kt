package me.abzylicious.unitebraverybot.dataclasses

import dev.kord.common.entity.Snowflake
import dev.kord.core.entity.Role
import dev.kord.core.entity.channel.Channel
import kotlinx.serialization.Serializable
import me.jakejmattson.discordkt.dsl.Data
import me.jakejmattson.discordkt.dsl.edit

@Serializable
data class Configuration (val guildConfigurations: MutableMap<Snowflake, GuildConfiguration> = mutableMapOf()) : Data() {
    operator fun get(id: Snowflake) = guildConfigurations[id]

    operator fun set(id: Snowflake, configuration: GuildConfiguration) {
        edit {
            guildConfigurations[id] = configuration
        }
    }

    fun hasGuildConfiguration(guildId: Snowflake) = guildConfigurations.containsKey(guildId)

    fun setup(
        guildId: Snowflake,
        prefix: String,
        adminRole: Role,
        loggingChannel: Channel,
        randomizeLane: Boolean,
        randomizeHeldItems: Boolean,
        randomizeBattleItems: Boolean
    ) {
        if (hasGuildConfiguration(guildId)) return

        val newConfiguration = GuildConfiguration(
            guildId.value.toString(),
            prefix,
            adminRole.id.value.toString(),
            loggingChannel.id.value.toString(),
            randomizeLane,
            randomizeHeldItems,
            randomizeBattleItems
        )

        edit {
            guildConfigurations[guildId] = newConfiguration
        }
    }
}

@Serializable
data class GuildConfiguration(
    val id: String = "",
    var prefix: String = "!",
    var adminRole: String = "insert_id",
    var loggingChannel: String = "insert_id",
    var randomizeLane: Boolean = false,
    var randomizeHeldItems: Boolean = false,
    var randomizeBattleItems: Boolean = false
)
