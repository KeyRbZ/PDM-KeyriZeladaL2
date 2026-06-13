package com.example.KMZBDOS.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "nombres")
data class Nombre(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nombre: String
)