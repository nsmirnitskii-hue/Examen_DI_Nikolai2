package com.example.flappymuskerteer.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

@Composable
fun AboutScreen() {
    val miniJuegos = listOf(
        MiniJuego("Juego de Memoria", "Recuerda las cartas y encuentra pares.", "memory_icon"),
        MiniJuego("3 en Raya", "Consigue 3 en raya antes que el rival.", "tictactoe_icon"),
        MiniJuego("Adivina el Número", "Adivina el número secreto.", "number_icon"),
        MiniJuego("Pulsa rápido", "Pulsa el botón tantas veces como puedas en 10 segundos.", "speed_icon"),
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            // Información del desarrollador
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                // Avatar (reemplaza con tu imagen)
                Box(
                    modifier = Modifier
                        .size(120.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.primary)
                ) {
                    Icon(
                        Icons.Default.Person,
                        contentDescription = "Desarrollador",
                        modifier = Modifier.size(60.dp),
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    "Tu Nombre",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    "Desarrollador Android",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Información de contacto
                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    IconButton(onClick = { /* GitHub */ }) {
                        Icon(Icons.Default.AccountCircle, contentDescription = "GitHub")
                    }
                    IconButton(onClick = { /* Email */ }) {
                        Icon(Icons.Default.Email, contentDescription = "Email")
                    }
                    IconButton(onClick = { /* LinkedIn */ }) {
                        Icon(Icons.Default.Person, contentDescription = "LinkedIn")
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))
            }
        }

        item {
            Text(
                "Otros Mini Juegos",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(16.dp))
        }

        items(miniJuegos.size) { index ->
            MiniGameTarjeta(miniJuegos[index])
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun MiniGameTarjeta(minijuego: MiniJuego) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Icono del juego (reemplaza con tus recursos)
            Box(
                modifier = Modifier
                    .size(60.dp)
                    .background(MaterialTheme.colorScheme.primaryContainer, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    Icons.Default.Info,
                    contentDescription = minijuego.titulo,
                    tint = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(
                    minijuego.titulo,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    minijuego.descripcion,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

data class MiniJuego(val titulo: String, val descripcion: String, val imageResId: String)