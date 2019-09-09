package com.mcgars.delegate_example.domain.model

/**
 * Simple model for [ru.mcgars.anibreak.feature.adapters.renders.RenderTitle]
 * show title
 */
data class Title(
        val value: String
) {
    override fun toString(): String {
        return value
    }
}