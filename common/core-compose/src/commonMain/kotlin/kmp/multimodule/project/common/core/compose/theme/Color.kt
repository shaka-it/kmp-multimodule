package kmp.multimodule.project.common.core.compose.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class AppColors(
    val primaryBackground: Color,
    val primaryAction: Color,
    val primaryTextColor: Color,
    val hintTextColor: Color,
    val highlightTextColor: Color,
    val secondaryTextColor: Color,
    val thirdTextColor: Color,
    val tagColor: Color,
    val tagTextColor: Color
)

val palette = AppColors(
    primaryBackground   = Color(0xFF000000),
    primaryAction       = Color(0xFFFFD700),
    primaryTextColor    = Color(0xFFFFFFFF),
    hintTextColor       = Color(0xFF888888),
    highlightTextColor  = Color(0xFFFFD700),
    secondaryTextColor  = Color(0xFFCCCCCC),
    thirdTextColor      = Color(0xFF666666),
    tagColor            = Color(0x33FFD700),
    tagTextColor        = Color(0xFFFFD700),
)

val LocalColorProvider = staticCompositionLocalOf { palette }