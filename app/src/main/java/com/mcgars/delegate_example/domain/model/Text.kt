package com.mcgars.delegate_example.domain.model

import androidx.annotation.DrawableRes

/**
 * Simple model for [ru.mcgars.anibreak.feature.adapters.delegate.TextDelegate]
 * show pair data
 */
data class Text(
        val name: String?,
        val subname: String? = null,
        val id: Int = 0,
        @DrawableRes
        val icon: Int = 0
)