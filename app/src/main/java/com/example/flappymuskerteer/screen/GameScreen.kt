package com.example.flappymuskerteer.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.times
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.delay
import kotlin.random.Random
import coil.compose.rememberAsyncImagePainter
import com.example.flappymuskerteer.viewmodel.GameViewModel

@Composable
fun GameScreen() {
    val viewModel: GameViewModel = viewModel()
    val anchoVentana = LocalConfiguration.current.screenWidthDp.dp
    val altoVentana = LocalConfiguration.current.screenHeightDp.dp

    var pajaroOffset by remember { mutableStateOf(altoVentana / 2) }

    // Crea las tuberías
    var tuberias by remember {
        mutableStateOf(
            List(3) { index ->
                Tuberia(
                    x = anchoVentana + index * 200.dp,
                    espacioY = Random.nextInt(200, 600).dp
                )
            }
        )
    }

    LaunchedEffect(Unit) {
        while (true) {
            delay(16)
            pajaroOffset += 4.dp

            tuberias = tuberias.map {
                var newX = it.x - 4.dp
                if (newX < -50.dp) {
                    newX = anchoVentana
                }
                it.copy(x = newX)
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(viewModel.colorFondo.value)
            .pointerInput(Unit) {
                detectTapGestures {
                    pajaroOffset -= 40.dp
                }
            }
    ) {
        // Fondo con imagen si está configurada
        viewModel.ImagenUriFondo.value?.let { uri ->
            val painter = rememberAsyncImagePainter(model = uri)
            Image(
                painter = painter,
                contentDescription = "Fondo galería",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds
            )
        }

        // Tuberías
        tuberias.forEach { tuberia ->
            val anchoTuberia = 50.dp
            val espacioAltura = 150.dp

            Box(
                modifier = Modifier
                    .offset(x = tuberia.x, y = 0.dp)
                    .size(width = anchoTuberia, height = tuberia.espacioY - espacioAltura / 2)
                    .background(viewModel.colorTuberias.value)
            )
            Box(
                modifier = Modifier
                    .offset(x = tuberia.x, y = tuberia.espacioY + espacioAltura / 2)
                    .size(width = anchoTuberia, height = altoVentana - tuberia.espacioY - espacioAltura / 2)
                    .background(viewModel.colorTuberias.value)
            )
        }

        // Jugador (pájaro)
        Box(
            modifier = Modifier
                .offset(x = 100.dp, y = pajaroOffset)
                .size(50.dp)
                .background(Color.Transparent)
        ) {
            // Si hay imagen del pájaro de Twitter, usarla, sino usar color
            if (viewModel.imagenResIdPajaro.value != null) {
                // Aquí usarías rememberAsyncImagePainter con el resource ID
                // Por ahora usamos un placeholder
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(viewModel.colorPajaro.value)
                )
            } else {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(viewModel.colorPajaro.value)
                )
            }
        }
    }
}

data class Tuberia(
    val x: Dp,
    val espacioY: Dp
)