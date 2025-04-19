package com.devndiplomacy.spendwise

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform