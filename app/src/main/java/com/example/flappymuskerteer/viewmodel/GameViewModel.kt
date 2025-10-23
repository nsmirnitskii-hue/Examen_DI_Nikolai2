package com.example.flappymuskerteer.viewmodel


import android.net.Uri
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel



class GameViewModel : ViewModel() {

    // PÁJARO
    val colorPajaro = mutableStateOf(Color.Red)
    val imagenResIdPajaro = mutableStateOf<Int?>(null)

    fun setColorPajaro(color: Color) {
        colorPajaro.value = color
        imagenResIdPajaro.value = null
    }

    fun setImagenPajaro(resId: Int) {
        imagenResIdPajaro.value = resId
    }

    // TUBERÍAS
    val colorTuberias = mutableStateOf(Color.Green)
    fun setColorTuberias(color: Color) {
        colorTuberias.value = color
    }

    // FONDO
    val colorFondo = mutableStateOf(Color.Cyan)
    val ImagenResIdFondo = mutableStateOf<Int?>(null)
    val ImagenUriFondo = mutableStateOf<Uri?>(null)

    fun setcolorFondo(color: Color) {
        colorFondo.value = color
        ImagenResIdFondo.value = null
        ImagenUriFondo.value = null
    }

    fun selectBackgroundImageRes(resId: Int) {
        ImagenResIdFondo.value = resId
        ImagenUriFondo.value = null
    }

    fun selectBackgroundImageUri(uri: Uri) {
        ImagenUriFondo.value = uri
        ImagenResIdFondo.value = null
    }


}
