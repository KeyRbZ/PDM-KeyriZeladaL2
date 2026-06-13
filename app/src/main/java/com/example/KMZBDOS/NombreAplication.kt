package com.example.KMZBDOS

import android.app.Application
import androidx.room.Room
import com.example.KMZBDOS.data.AppDatabase

class NombreApplication : Application() {
    companion object {
        lateinit var database: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(
            this,
            AppDatabase::class.java,
            "NombresDB"
        ).fallbackToDestructiveMigration(false).build()
    }
}