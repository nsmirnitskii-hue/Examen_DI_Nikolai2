package com.example.flappymuskerteer.navigation

import android.content.Context
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(context: Context) {
    TopAppBar(
        title = {  },
        actions = {
            IconButton(onClick = {

            }) {
                Icon(Icons.Default.AccountCircle, contentDescription = "GitHub")
            }
            //Anadir los demas iconos.

        }
    )
}