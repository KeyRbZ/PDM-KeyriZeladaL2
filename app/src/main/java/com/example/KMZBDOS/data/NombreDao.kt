package com.example.KMZBDOS.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface NombreDao {

    @Query("SELECT * FROM nombres")
    fun getAllNombres(): Flow<List<Nombre>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(nombre: Nombre)

    @Query("DELETE FROM nombres")
    suspend fun limpiar()
}