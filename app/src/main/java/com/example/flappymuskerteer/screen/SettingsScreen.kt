package com.example.flappymuskerteer.screen

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.flappymuskerteer.viewmodel.GameViewModel

@Composable
fun SettingsScreen() {
    val viewModel: GameViewModel = viewModel()

    val coloresPajaro = listOf(Color.Red, Color.Blue, Color.Yellow, Color.Green)
    val coloresTuberias = listOf(Color.Green, Color.DarkGray, Color.Cyan, Color.Magenta)
    val coloresFondo = listOf(Color.Cyan, Color.LightGray, Color.White, Color(0xFFFFE0B2))

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        if (uri != null) {
            viewModel.selectBackgroundImageUri(uri)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Configuración del pájaro
        Text(
            "Pájaro",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            coloresPajaro.forEach { color ->
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(MaterialTheme.shapes.medium)
                        .background(color)
                        .clickable { viewModel.setColorPajaro(color) }
                )
            }
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(MaterialTheme.shapes.medium)
                    .background(Color.White)
                    .clickable {
                        // Aquí se configuraría la imagen del pájaro de Twitter
                        // viewModel.setImagenPajaro(R.drawable.twitter_bird)
                    }
            ) {
                // Icono de Twitter (placeholder)
                Icon(
                    painter = painterResource(android.R.drawable.sym_action_chat),
                    contentDescription = "Pájaro Twitter",
                    modifier = Modifier.size(24.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Configuración de las tuberías
        Text(
            "Tuberías",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            coloresTuberias.forEach { color ->
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(MaterialTheme.shapes.medium)
                        .background(color)
                        .clickable { viewModel.setColorTuberias(color) }
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Configuración del fondo
        Text(
            "Fondo",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            coloresFondo.forEach { color ->
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(MaterialTheme.shapes.medium)
                        .background(color)
                        .clickable { viewModel.setcolorFondo(color) }
                )
            }

            // Imagen de atardecer
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(MaterialTheme.shapes.medium)
                    .background(Color(0xFFFFA726))
                    .clickable {
                        // viewModel.selectBackgroundImageRes(R.drawable.sunset)
                    }
            ) {
                Icon(
                    Icons.Default.Add,
                    contentDescription = "Atardecer",
                    modifier = Modifier.size(24.dp),
                    tint = Color.White
                )
            }

            // Seleccionar de galería
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(MaterialTheme.shapes.medium)
                    .background(Color.LightGray)
                    .clickable { launcher.launch("image/*") }
            ) {
                Icon(
                    Icons.Default.Add,
                    contentDescription = "Galeria",
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}