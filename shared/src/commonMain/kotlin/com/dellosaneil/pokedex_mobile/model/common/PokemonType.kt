package com.dellosaneil.pokedex_mobile.model.common

enum class PokemonType {
    NORMAL,
    FIGHTING,
    FLYING,
    POISON,
    GROUND,
    ROCK,
    BUG,
    GHOST,
    STEEL,
    FIRE,
    WATER,
    GRASS,
    ELECTRIC,
    PSYCHIC,
    ICE,
    DRAGON,
    DARK,
    FAIRY,
    SHADOW,
    UNKNOWN;

    override fun toString(): String {
        return name.lowercase()
    }

    companion object {
        fun getType(id: Int): PokemonType {
            if (id == 10001 || id == 0) {
                return UNKNOWN
            }
            if (id == 10002) {
                return SHADOW
            }
            val typeList = values()
            return typeList[id.dec()]
        }
    }
}
