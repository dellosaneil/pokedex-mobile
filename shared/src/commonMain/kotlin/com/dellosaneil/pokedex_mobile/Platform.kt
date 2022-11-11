package com.dellosaneil.pokedex_mobile

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
