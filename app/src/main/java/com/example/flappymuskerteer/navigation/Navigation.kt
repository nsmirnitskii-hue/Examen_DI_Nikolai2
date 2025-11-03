package com.example.flappymuskerteer.navigation

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.flappymuskerteer.screen.AboutScreen
import com.example.flappymuskerteer.screen.GameScreen
import com.example.flappymuskerteer.screen.SettingsScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val context = LocalContext.current

    Scaffold(
        topBar = { TopBar(context) },
        bottomBar = { BottomNavigationBar(navController) }
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = "game",
            modifier = Modifier.padding(padding)
        ) {
            composable("game") { GameScreen() }
            composable("about") { AboutScreen() }
            composable("settings") { SettingsScreen() }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(context: Context) {
    TopAppBar(
        title = { Text("Flappy Muskerteer") },
        actions = {
            // Email button
            IconButton(onClick = {
                val intent = Intent(Intent.ACTION_SEND).apply {
                    type = "message/rfc822"
                    putExtra(Intent.EXTRA_EMAIL, arrayOf("desarrollador@ejemplo.com"))
                    putExtra(Intent.EXTRA_SUBJECT, "Contacto Flappy Bird")
                    putExtra(Intent.EXTRA_TEXT, "Hola, me contacto respecto a Flappy Bird...")
                }
                context.startActivity(Intent.createChooser(intent, "Enviar email"))
            }) {
                Icon(Icons.Default.Email, contentDescription = "Email")
            }

            // GitHub button
            IconButton(onClick = {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/tuusuario"))
                context.startActivity(intent)
            }) {
                Icon(Icons.Default.AccountCircle, contentDescription = "GitHub")
            }

            // Share button
            IconButton(onClick = {
                val intent = Intent(Intent.ACTION_SEND).apply {
                    type = "text/plain"
                    putExtra(Intent.EXTRA_TEXT, "¡Mira este increíble juego Flappy Bird que he creado!")
                }
                context.startActivity(Intent.createChooser(intent, "Compartir"))
            }) {
                Icon(Icons.Default.Share, contentDescription = "Compartir")
            }
        }
    )
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    NavigationBar {
        NavigationBarItem(
            icon = { Icon(Icons.Default.PlayArrow, contentDescription = "Jugar") },
            label = { Text("Jugar") },
            selected = navController.currentDestination?.route == "game",
            onClick = { navController.navigate("game") }
        )

        NavigationBarItem(
            icon = { Icon(Icons.Default.Info, contentDescription = "Acerca de") },
            label = { Text("Acerca de") },
            selected = navController.currentDestination?.route == "about",
            onClick = { navController.navigate("about") }
        )

        NavigationBarItem(
            icon = { Icon(Icons.Default.Settings, contentDescription = "Configuración") },
            label = { Text("Configuración") },
            selected = navController.currentDestination?.route == "settings",
            onClick = { navController.navigate("settings") }
        )
    }
}