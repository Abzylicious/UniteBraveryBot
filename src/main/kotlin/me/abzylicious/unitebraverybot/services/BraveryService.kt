package me.abzylicious.unitebraverybot.services

import dev.kord.common.entity.Snowflake
import me.abzylicious.unitebraverybot.dataclasses.*
import me.abzylicious.unitebraverybot.util.Randomizer
import me.jakejmattson.discordkt.annotations.Service

@Service
class BraveryService(private val configuration: Configuration, private val pokemonPool: PokemonPool) {
    fun getBraveryBuild(guildId: Snowflake): BraveryBuild {
        val randomPokemon = getRandomPokemon()
        return BraveryBuild(
            randomPokemon,
            getRandomLane(guildId),
            getRandomHeldItems(guildId),
            getRandomBattleItem(guildId),
            getRandomMoves(guildId, randomPokemon),
        )
    }
    
    private fun getRandomPokemon(): Pokemon {
        val randomizer = Randomizer()
        return randomizer.selectRandom(pokemonPool.pokemon).first()
    }

    private fun getRandomLane(guildId: Snowflake): Lane? {
        val randomize = configuration[guildId]?.randomizeLane ?: return null
        if (randomize) {
            val randomizer = Randomizer()
            return randomizer.selectRandom(Lane.values().toList()).first()
        }
        return null
    }

    private fun getRandomHeldItems(guildId: Snowflake): List<HeldItem>? {
        val randomize = configuration[guildId]?.randomizeHeldItems ?: return null
        if (randomize) {
            val randomizer = Randomizer()
            return randomizer.selectRandom(HeldItem.values().toList(), 3)
        }
        return null
    }

    private fun getRandomBattleItem(guildId: Snowflake): BattleItem? {
        val randomize = configuration[guildId]?.randomizeBattleItems ?: return null
        if (randomize) {
            val randomizer = Randomizer()
            return randomizer.selectRandom(BattleItem.values().toList()).first()
        }
        return null
    }

    private fun getRandomMoves(guildId: Snowflake, pokemon: Pokemon): Pair<String, String>? {
        val randomize = configuration[guildId]?.randomizeMoves ?: return null
        if (randomize) {
            val randomizer = Randomizer()
            val firstMove = randomizer.selectRandom(pokemon.firstMoveOptions).first()
            val secondMove = randomizer.selectRandom(pokemon.secondMoveOptions).first()
            return Pair(firstMove, secondMove)
        }
        return null
    }
}
