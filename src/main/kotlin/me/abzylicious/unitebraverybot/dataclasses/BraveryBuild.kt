package me.abzylicious.unitebraverybot.dataclasses

data class BraveryBuild(
    val pokemon: Pokemon,
    val lane: Lane? = null,
    val heldItems: List<HeldItem>? = null,
    val battleItem: BattleItem? = null
)
