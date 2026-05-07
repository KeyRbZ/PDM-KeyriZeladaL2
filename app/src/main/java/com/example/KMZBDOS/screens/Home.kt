package com.example.KMZBDOS.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    onGoLista: () -> Unit,
    onGoSensores: () -> Unit
) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Button(onClick = onGoLista) {
            Text("Lista de nombres")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = onGoSensores) {
            Text("Sensores")
        }
    }
}