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
import kotlinx.coroutines.delay
import kotlin.random.Random
import androidx.compose.ui.unit.times
import coil.compose.rememberAsyncImagePainter

@Composable
fun GameScreen() {
    val anchoVentana = LocalConfiguration.current.screenWidthDp.dp
    val altoVentana = LocalConfiguration.current.screenHeightDp.dp

    var pajaroOffset by remember { mutableStateOf(altoVentana / 2) }

    //Crea las tuberías
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
            // Fondo: color o imagen (resource o Uri) Si la Uri es nula, se dibuja el resource, si este es nulo se dibuja el color
            .background(Color.Cyan)
            .pointerInput(Unit) {
                detectTapGestures {
                    pajaroOffset -= 40.dp
                }
            }
    ) {

        val uri = null
        if (uri != null) {
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
                    .background(Color.DarkGray)
            )
            Box(
                modifier = Modifier
                    .offset(x = tuberia.x, y = tuberia.espacioY + espacioAltura / 2)
                    .size(width = anchoTuberia, height = altoVentana - tuberia.espacioY - espacioAltura / 2)
                    .background(Color.DarkGray)
            )
        }

        // Jugador (pájaro): imagen (resource) o color, encadenar condiciones
        Box(
            modifier = Modifier
                .offset(x = 100.dp, y = pajaroOffset)
                .size(50.dp)
                .background(Color.Transparent)
        ) {

                // Si no hay imagen, pintar el pájaro como un cuadrado de color
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Red)
                )

        }

    }
}

data class Tuberia(
    val x: Dp,
    val espacioY: Dp
)
