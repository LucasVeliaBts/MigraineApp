package com.example.migraineapp

import android.app.Application


class CrisesApplication : Application() {
    // Using by lazy so the database and the repository are only created when they're needed
    // rather than when the application starts
    val database by lazy { CriseRoomDatabase.getDatabase(this) }
    val repository by lazy { CriseRepository(database.criseDao()) }
}

