# 🐦 Flappy Bird — Examen Jetpack Compose

**Flappy Bird** es un videojuego móvil de estilo arcade creado por el desarrollador vietnamita **Dong Nguyen** y lanzado en 2013.  
Se volvió un fenómeno mundial en 2014 por su jugabilidad extremadamente simple pero frustrante, y por su capacidad adictiva.

---

## Funcionamiento

El jugador controla un pájaro que vuela automáticamente hacia la derecha.

- Cada toque en la pantalla hace que el ave “salte” o aletee hacia arriba.
- Si el jugador no toca la pantalla, el pájaro cae por gravedad.
- El objetivo es atravesar un conjunto de tubos, sin chocar con ellos ni con el suelo.

---

## UI

Se os proporciona un proyecto con parte del juego realizado.  
Vuestra tarea es que la **interfaz gráfica** se parezca a las siguientes capturas de pantalla.

---

<table>
  <tr>
    <td><img src="app/src/main/res/drawable/Captura1.png" alt="Captura de pantalla" width="%15" style="display: inline-block; margin-right: %1;" /></td>
    <td><img src="app/src/main/res/drawable/Captura2.png" alt="Captura de pantalla" width="%15" style="display: inline-block; margin-right: %1;"/></td>
    <td><img src="app/src/main/res/drawable/Captura3.png" alt="Captura de pantalla" width="%15" style="display: inline-block; margin-right: %1;"/></td>
    <td><img src="app/src/main/res/drawable/Captura4.png" alt="Captura de pantalla" width="%15" style="display: inline-block; margin-right: %1;"/></td>
  </tr>
</table>

---

## Estructura de proyecto

El proyecto consta de los siguientes paquetes: `navigation`, `screen` y `viewmodel`:

- **MainActivity.kt**

- **AppNavigation.kt**  
  En este fichero debéis crear la estructura de la aplicación, para que tenga una barra superior e inferior en todas las ventanas.  

  **En la barra superior debéis realizar las siguientes 3 funcionalidades:**
  1. Mandar un email al desarrollador (vosotros).  
  2. Un enlace que redirija a vuestro GitHub.  
  3. Compartir un mensaje por WhatsApp u otra aplicación.  

  **En la barra inferior** debéis colocar la navegación entre las ventanas, con sus correspondientes iconos.

- **AboutScreen.kt**  
  Tenéis que diseñar una ventana de información sobre el desarrollador (vosotros) y otros juegos que habéis programado.  
  Tiene que ser parecida a las capturas de pantalla; las imágenes se os proporcionan.

- **GameScreen.kt**  
  Tiene la lógica del juego programada. Tendréis que realizar algún cambio para que funcione la pantalla *Settings*.

- **SettingsScreen.kt**  
  Es la ventana que se encarga de la configuración del juego.  
  Como se observa en la imagen, tiene que tener **3 filas**:
  1. La primera para configurar el pájaro.  
  2. La segunda para configurar las tuberías.  
  3. La tercera para configurar el fondo.  

  El pájaro puede cambiar de color o personalizarse con la imagen del pájaro de Twitter, la cual se os proporciona.  
  Las tuberías solo pueden cambiar de color.  
  El fondo puede tener 3 colores, o la imagen del atardecer (proporcionada), o una imagen elegida de la galería.  
  Para ello se pondrá un botón con un símbolo de “+”.

- **GameViewModel.kt**  
  Es el *ViewModel* del juego. Se os proporciona ya hecho, no hace falta que realicéis cambios.

---

## Entrega

- Proyecto completo en **GitHub**.  
- Debe compilar correctamente y funcionar sin errores.  
- Se valorará la coherencia visual y el uso correcto de los componentes de **Jetpack Compose**.

---

## Criterios de evaluación

| Criterio | Ponderación |
|-----------|-------------|
| Correcta implementación de la navegación | 20% |
| Barra superior e inferior funcionales | 20% |
| Diseño fiel a las capturas | 20% |
| Funcionamiento de la pantalla de configuración | 30% |
| Limpieza del código y uso adecuado de ViewModel | 10% |
