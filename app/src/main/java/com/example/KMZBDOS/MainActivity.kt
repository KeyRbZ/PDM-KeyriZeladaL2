package com.example.KMZBDOS

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import com.example.KMZBDOS.screens.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            var screen by rememberSaveable() { mutableStateOf("home") }

            when (screen) {

                "home" -> HomeScreen(
                    onGoLista = { screen = "lista" },
                    onGoSensores = { screen = "sensores" })

                "lista" -> PantallaListaNombres(
                    onBack = { screen = "home" })

                "sensores" -> LightSensor(
                    onBack = { screen = "home" })
            }
        }
    }
}