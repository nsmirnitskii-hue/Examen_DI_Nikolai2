package com.example.flappymuskerteer.screen

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


data class MiniJuego(val titulo: String, val descripcion: String, val imageResId: Int)

@Composable
fun AboutScreen() {
    val miniJuegos = listOf(
        MiniJuego("Juego de Memoria", "Recuerda las cartas y encuentra pares.",0),
        MiniJuego("3 en Raya", "Consigue 3 en raya antes que el rival.",0),
        MiniJuego("Adivina el Número", "Adivina el número secreto.",0),
        MiniJuego("Pulsa rápido", "Pulsa el botón tantas veces como puedas en 10 segundos.",0),
    )


}

@Composable
fun MiniGameTarjeta(minijuego:MiniJuego) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {

    }
}





