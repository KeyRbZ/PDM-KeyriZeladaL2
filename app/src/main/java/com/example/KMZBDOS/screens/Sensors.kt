package com.example.KMZBDOS.screens

import android.content.Context
import android.hardware.*
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LightSensor(
    onBack: () -> Unit = {}
) {

    val context = LocalContext.current

    val sensorManager = remember {
        context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
    }

    val lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)

    var lightValue by remember { mutableStateOf(0f) }

    DisposableEffect(Unit) {

        val listener = object : SensorEventListener {

            override fun onSensorChanged(event: SensorEvent) {
                lightValue = event.values[0]
            }

            override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}
        }

        sensorManager.registerListener(
            listener,
            lightSensor,
            SensorManager.SENSOR_DELAY_NORMAL
        )

        onDispose {
            sensorManager.unregisterListener(listener)
        }
    }

    Scaffold { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Button(onClick = onBack) {
                Text("Regresar")
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Sensor de Luz",
                fontSize = 24.sp
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Intensidad: $lightValue lx",
                fontSize = 18.sp
            )
        }
    }
}