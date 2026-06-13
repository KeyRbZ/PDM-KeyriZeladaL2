package com.example.KMZBDOS.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Nombre::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun nombreDao(): NombreDao
}