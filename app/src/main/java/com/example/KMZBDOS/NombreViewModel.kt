package com.example.KMZBDOS

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.KMZBDOS.data.Nombre
import kotlinx.coroutines.launch

class NombreViewModel : ViewModel() {
    private val dao = NombreApplication.database.nombreDao()

    val nombres = dao.getAllNombres()

    fun agregar(nombre: String) {
        viewModelScope.launch {
            dao.insertar(Nombre(nombre = nombre))
        }
    }

    fun limpiar() {
        viewModelScope.launch {
            dao.limpiar()
        }
    }
}