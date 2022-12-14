package me.abzylicious.unitebraverybot.locale

object BotConstants {
    const val BOT_TOKEN = "BOT_TOKEN"
    const val DEFAULT_PREFIX = "DEFAULT_PREFIX"
    const val DEFAULT_PREFIX_VALUE = "brave!"
    const val CONFIGURATION_DATA_PATH = "data/config.json"
    const val POKEMON_DATA_PATH = "data/pokemon.json"
    const val PRESENCE_PLAYING = "with brave Pokemon picks & builds"
    const val CONVERSATION_EXIT_COMMAND = "exit"
}

object Templates {
    const val GUILD_NAME = "%GUILD_NAME%"
    const val PREFIX = "%PREFIX%"
    const val ROLE = "%AROLE%"
    const val CHANNEL = "%CHANNEL%"
    const val CHOICE = "%CHOICE%"
    const val POKEMON = "%POKEMON%"
    const val POKEMON_COUNT = "%POKEMON_COUNT%"
}

object Labels {
    const val YES = "Yes"
    const val NO = "No"
    const val ENABLED = "Enabled"
    const val DISABLED = "Disabled"
    const val SETUP_PREFIX_TITLE = "Setup - Prefix"
    const val SETUP_ADMIN_ROLE_TITLE = "Setup - Admin Role"
    const val SETUP_LOGGING_CHANNEL_TITLE = "Setup - Logging Channel"
    const val SETUP_RANDOMIZE_LANE_TITLE = "Setup - Lane Randomization"
    const val SETUP_RANDOMIZE_HELD_ITEMS_TITLE = "Setup - Held Items Randomization"
    const val SETUP_RANDOMIZE_BATTLE_ITEMS_TITLE = "Setup - Battle Items Randomization"
    const val SETUP_RANDOMIZE_MOVES_TITLE = "Setup - Moves Randomization"
    const val CONFIGURATION_TITLE = "${Templates.GUILD_NAME} - Configuration"
    const val CONFIGURATION_PREFIX = "Bot Prefix"
    const val CONFIGURATION_ADMIN_ROLE = "Admin Role"
    const val CONFIGURATION_LOGGING_CHANNEL = "Logging Channel"
    const val CONFIGURATION_RANDOMIZER_OPTIONS = "Randomizer Options"
    const val CONFIGURATION_LANE_RANDOMIZATION = "Randomize Lane"
    const val CONFIGURATION_HELD_ITEMS_RANDOMIZATION = "Randomize Held Items"
    const val CONFIGURATION_BATTLE_ITEM_RANDOMIZATION = "Randomize Battle Items"
    const val CONFIGURATION_MOVES_RANDOMIZATION = "Randomize Moves"
    const val BRAVERY_BUILD_TITLE = "Your Pokemon has been chosen!"
    const val BRAVERY_BUILD_DESCRIPTION = "During your next match you have to pick the following Pokemon: **${Templates.POKEMON}**"
    const val BRAVERY_BUILD_LANE = "Lane"
    const val BRAVERY_BUILD_HELD_ITEMS = "Held Items"
    const val BRAVERY_BUILD_BATTLE_ITEMS = "Battle Item"
    const val BRAVERY_BUILD_FIRST_MOVE = "First Move"
    const val BRAVERY_BUILD_SECOND_MOVE = "Second Move"
    const val BRAVERY_BUILD_REROLL = "Reroll"
}

object Messages {
    const val NO_TOKEN_PROVIDED = "Expected the bot token as argument or an environment variable"
    const val GUILD_CONFIGURATION_EXISTS = "Guild configuration exists. To modify it use the respective commands to set values."
    const val GUILD_CONFIGURATION_NOT_FOUND = "Guild configuration not found. Please run the **/configuration setup** command to set this initially."
    const val SETUP_PREFIX_DECISION = "Would you like to set a new bot prefix? The default bot prefix is **${BotConstants.DEFAULT_PREFIX_VALUE}**."
    const val SETUP_PREFIX = "Set the bots prefix for this guild. This can be changed later via the **/configuration prefix** command."
    const val SETUP_ADMIN_ROLE = "Set the bots admin role for this guild. This can later be changed via the **/configuration adminrole** command."
    const val SETUP_LOGGING_CHANNEL = "Set the bots logging channel for this guild. This can later be changed via the **/configuration loggingchannel** command."
    const val SETUP_RANDOMIZE_LANE = "Set Lane randomization. This can later be changed via the **/randomizer lane** command."
    const val SETUP_RANDOMIZE_HELD_ITEMS = "Set Held Items randomization. This can later be changed via the **/randomizer helditems** command."
    const val SETUP_RANDOMIZE_BATTLE_ITEMS = "Set Battle Item randomization. This can later be changed via the **/randomizer battleitem** command."
    const val SETUP_RANDOMIZE_MOVES = "Set Moves randomization. This can later be changed via the **/randomizer moves** command."
    const val SETUP_COMPLETE = "Setup complete for **${Templates.GUILD_NAME}**! \uD83C\uDF89"
    const val CONFIGURATION_SET_PREFIX = "Prefix set to **${Templates.PREFIX}**"
    const val CONFIGURATION_SET_ADMIN_ROLE = "Admin role set to **${Templates.ROLE}**"
    const val CONFIGURATION_SET_LOGGING_CHANNEL = "Logging channel set to **${Templates.CHANNEL}**"
    const val CONFIGURATION_SET_LANE_RANDOMIZATION = "**${Templates.CHOICE}** Lane randomization"
    const val CONFIGURATION_SET_HELD_ITEMS_RANDOMIZATION = "**${Templates.CHOICE}** Held Items randomization"
    const val CONFIGURATION_SET_BATTLE_ITEM_RANDOMIZATION = "**${Templates.CHOICE}** Battle Items randomization"
    const val CONFIGURATION_SET_MOVES_RANDOMIZATION = "**${Templates.CHOICE}** Moves randomization"
    const val BRAVERY_BUILD_RESULT = "Here is your bravery build"
    const val STARTUP_LOG = "\u2705 Bot successfully initialized"
    const val POKEMON_ROSTER_LOG = "\u2139 There are **${Templates.POKEMON_COUNT}** pokemon available"
}

object CommandDescriptions {
    const val UTILITY_PING = "Check the status of the bot"
    const val CONFIGURATION_SHOW = "Show the current guild configuration"
    const val CONFIGURATION_SETUP = "Configure this guild to use this bot"
    const val CONFIGURATION_PREFIX = "Set the bots prefix for this guild"
    const val CONFIGURATION_ADMIN_ROLE = "Set the bots admin role for this guild"
    const val CONFIGURATION_LOGGING_CHANNEL = "Set the bots logging channel for this guild"
    const val RANDOMIZER_LANE_RANDOMIZATION = "Set Lane randomization"
    const val RANDOMIZER_HELD_ITEMS_RANDOMIZATION = "Set Held Items randomization"
    const val RANDOMIZER_BATTLE_ITEM_RANDOMIZATION = "Set Battle Item randomization"
    const val RANDOMIZER_MOVES_RANDOMIZATION = "Set Moves randomization"
    const val BRAVERY_ROLL = "Get a spicy build for your next Pokemon Unite match"
}
