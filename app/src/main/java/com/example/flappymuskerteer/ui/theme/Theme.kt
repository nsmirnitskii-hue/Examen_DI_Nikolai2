package com.example.flappymuskerteer.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

val spacePurple = Color(0xFF6A0DAD)
val earthYellow = Color(0xFFE1A95F)

val twitterBlue = Color(0xFF1DA1F2)



val spaceX = darkColorScheme(
    primary = spacePurple,
    secondary = Color.Black,
    tertiary = Color.Black
)

val twitter = darkColorScheme(
    primary = earthYellow,
    secondary = twitterBlue,
    tertiary = Color.Black
)

enum class GameBackground(val url: String) {
    TWITTER_DOGE("https://source.unsplash.com/qIRJeKdieKA"),
    SPACE_X("https://source.unsplash.com/ln5drpv_ImI"),
    SPACE_X_MOON("https://source.unsplash.com/Na0BbqKbfAo"),
    SPACE_X_MARS("https://source.unsplash.com/-_5dCixJ6FI")
}

@Composable
fun FlappyMuskerTeerTheme(
    colorScheme: ColorScheme = twitter,
    content: @Composable () -> Unit
) {
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            window.navigationBarColor = colorScheme.primary.toArgb()
        }
    }
    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}