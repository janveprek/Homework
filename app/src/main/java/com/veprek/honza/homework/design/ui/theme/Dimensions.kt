package com.veprek.honza.homework.design.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class Dimensions(
    val spacingSmall: Dp = 4.dp,
    val spacingMedium: Dp = 8.dp,
    val spacingMediumLarge: Dp = 12.dp,
    val spacingLarge: Dp = 16.dp,
    val spacingExtraLarge: Dp = 20.dp,
    val shadowHeight: Dp = 8.dp,
    val loadingIndicatorSize: Dp = 64.dp,
    val loadingIndicatorStrokeWidth: Dp = 4.dp,
)

val LocalThemeDimensions = staticCompositionLocalOf { Dimensions() }