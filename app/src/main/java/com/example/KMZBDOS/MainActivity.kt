package com.example.KMZBDOS

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                PantallaListaNombres()
            }
        }
    }
}

@Composable
fun PantallaListaNombres() {

    var nombre by remember { mutableStateOf(TextFieldValue("")) }
    var listaNombres by remember { mutableStateOf(listOf<String>()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFCDB4DB)) // Fondo lila pastel
            .padding(16.dp)
    ) {

        TextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre") },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color(0xFFF8E1F4)
            ),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = {
                if (nombre.text.isNotEmpty()) {
                    listaNombres = listaNombres + nombre.text
                    nombre = TextFieldValue("")
                }
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFF8FAB),
                contentColor = Color.White
            ),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("Guardar")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "Listado de nombres y posición en la lista",
                fontSize = 18.sp,
                color = Color(0xFF5E548E)
            )

            Button(
                onClick = {
                    listaNombres = listOf()
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFF8FAB),
                    contentColor = Color.White
                )
            ) {
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
                itemsIndexed(listaNombres) { index, nombreGuardado ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = nombreGuardado)
                        Text(text = "${index + 1}")
                    }
                }
            }
        }
    }
}