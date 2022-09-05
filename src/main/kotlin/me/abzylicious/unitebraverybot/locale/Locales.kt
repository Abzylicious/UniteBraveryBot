package me.abzylicious.unitebraverybot.locale

object BotConstants {
    const val BOT_TOKEN = "BOT_TOKEN"
    const val DEFAULT_PREFIX = "DEFAULT_PREFIX"
    const val DEFAULT_PREFIX_VALUE = "brave!"
    const val CONFIGURATION_DATA_PATH = "data/config.json"
    const val PRESENCE_PLAYING = "with brave Pokemon picks & builds"
}

object Templates {
    const val GUILD_NAME = "%GUILD_NAME%"
    const val PREFIX = "%PREFIX%"
    const val ROLE = "%AROLE%"
    const val CHANNEL = "%CHANNEL%"
}

object Labels {
    const val YES = "Yes"
    const val NO = "No"
    const val SETUP_PREFIX_TITLE = "Setup - Prefix"
    const val SETUP_ADMIN_ROLE_TITLE = "Setup - Admin Role"
    const val SETUP_LOGGING_CHANNEL_TITLE = "Setup - Logging Channel"
    const val SETUP_RANDOMIZE_LANE_TITLE = "Setup - Lane Randomization"
    const val SETUP_RANDOMIZE_HELD_ITEMS_TITLE = "Setup - Held Items Randomization"
    const val SETUP_RANDOMIZE_BATTLE_ITEMS_TITLE = "Setup - Battle Items Randomization"
    const val CONFIGURATION_TITLE = "${Templates.GUILD_NAME} - Configuration"
    const val CONFIGURATION_PREFIX = "Bot Prefix"
    const val CONFIGURATION_ADMIN_ROLE = "Admin Role"
    const val CONFIGURATION_LOGGING_CHANNEL = "Logging Channel"
    const val CONFIGURATION_LANE_RANDOMIZATION = "Randomize Lane"
    const val CONFIGURATION_HELD_ITEMS_RANDOMIZATION = "Randomize Held Items"
    const val CONFIGURATION_BATTLE_ITEM_RANDOMIZATION = "Randomize Battle Items"
}

object Messages {
    const val NO_TOKEN_PROVIDED = "Expected the bot token as argument or an environment variable"
    const val GUILD_CONFIGURATION_EXISTS = "Guild configuration exists. To modify it use the respective commands to set values."
    const val GUILD_CONFIGURATION_NOT_FOUND = "Guild configuration not found. Please run the **configure** command to set this initially."
    const val SETUP_PREFIX_DECISION = "Would you like to set a new bot prefix? The default bot prefix is **${BotConstants.DEFAULT_PREFIX_VALUE}**. This can be changed later via the **setprefix** command."
    const val SETUP_PREFIX = "Set the bots prefix for this guild."
    const val SETUP_ADMIN_ROLE = "Set the bots admin role for this guild. This can later be changed via the **setadminrole** command."
    const val SETUP_LOGGING_CHANNEL = "Set the bots logging channel for this guild. This can later be changed via the **setloggingchannel** command."
    const val SETUP_RANDOMIZE_LANE = "Set Lane randomization. This can later be changed via the **setlanerandomization** command."
    const val SETUP_RANDOMIZE_HELD_ITEMS = "Set Held Items randomization. This can later be changed via the **sethelditemsrandomization** command."
    const val SETUP_RANDOMIZE_BATTLE_ITEMS = "Set Battle Item randomization. This can later be changed via the **setbattleitemrandomization** command."
    const val SETUP_COMPLETE = "Setup complete for **${Templates.GUILD_NAME}**! \uD83C\uDF89"
    const val CONFIGURATION_SET_PREFIX = "Prefix set to **${Templates.PREFIX}**"
    const val CONFIGURATION_SET_ADMIN_ROLE = "Admin role set to **${Templates.ROLE}**"
    const val CONFIGURATION_SET_LOGGING_CHANNEL = "Logging channel set to **${Templates.CHANNEL}**"
    const val CONFIGURATION_SET_LANE_RANDOMIZATION = "Set Lane randomization"
    const val CONFIGURATION_SET_HELD_ITEMS_RANDOMIZATION = "Set Held Items randomization"
    const val CONFIGURATION_SET_BATTLE_ITEM_RANDOMIZATION = "Set Battle Items randomization"
}

object CommandDescriptions {
    const val UTILITY_PING = "Check the status of the bot"
    const val CONFIGURATION_CONFIGURATION = "Show the current guild configuration"
    const val CONFIGURATION_CONFIGURE = "Configure this guild to use this bot"
    const val CONFIGURATION_SET_PREFIX = "Set the bots prefix for this guild"
    const val CONFIGURATION_SET_ADMIN_ROLE = "Set the bots admin role for this guild"
    const val CONFIGURATION_SET_LOGGING_CHANNEL = "Set the bots logging channel for this guild"
    const val CONFIGURATION_SET_LANE_RANDOMIZATION = "Set Lane randomization"
    const val CONFIGURATION_SET_HELD_ITEMS_RANDOMIZATION = "Set Held Items randomization"
    const val CONFIGURATION_SET_BATTLE_ITEM_RANDOMIZATION = "Set Battle Item randomization"
}
