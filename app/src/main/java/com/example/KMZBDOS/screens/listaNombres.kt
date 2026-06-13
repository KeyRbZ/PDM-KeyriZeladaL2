package com.example.KMZBDOS.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.KMZBDOS.NombreViewModel

@Composable
fun PantallaListaNombres(
    onBack: () -> Unit
) {
    val viewModel: NombreViewModel = viewModel()
    val listaNombres by viewModel.nombres.collectAsState(initial = emptyList())
    var nombre by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFCDB4DB))
            .padding(16.dp)
    ) {
        Button(onClick = onBack) {
            Text("Regresar")
        }

        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = {
                if (nombre.isNotEmpty()) {
                    viewModel.agregar(nombre)
                    nombre = ""
                }
            }
        ) {
            Text("Guardar")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Listado de nombres")
            Button(onClick = { viewModel.limpiar() }) {
                Text("Limpiar")
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .border(3.dp, Color(0xFFB5838D))
                .padding(8.dp)
        ) {
            LazyColumn {
                itemsIndexed(listaNombres) { index, item ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(item.nombre)
                        Text("${index + 1}")
                    }
                }
            }
        }
    }
}