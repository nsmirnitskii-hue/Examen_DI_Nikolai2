package com.example.flappymuskerteer.screen

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable


@Composable
fun SettingsScreen() {


        val coloresPajaro = listOf(Color.Red, Color.Blue, Color.Yellow)


        val coloresTuberias = listOf(Color.Green, Color.DarkGray, Color.Cyan)

        val coloresFondo = listOf(Color.Cyan, Color.LightGray, Color.White)

        val launcher = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.GetContent()
        ) { uri: Uri? ->
            if (uri != null) {
                //Aqui es donde se recoge la imagen elegida de la galeria
            }
        }



        Column(modifier = Modifier.padding(16.dp)) {

            Text("Pájaro", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                coloresPajaro.forEach { color ->
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .background(Color.White)
                            .clickable { }

                    )
                }
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .background(Color.White) // fondo blanco detrás
                        .clickable {  }
                ) {
                    //Añadir aquí la imagen del pájaro de twitter
                }
            }

            //Hacer lo mismo con las tuberías

            //Hacer lo mismo con el fondo


        }

}


