package com.example.flappymuskerteer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.flappymuskerteer.screen.GameScreen
import com.example.flappymuskerteer.ui.theme.FlappyMuskerTeerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FlappyMuskerTeerTheme {
                GameScreen()
            }
        }
    }
}
