package com.example.migraineapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase



/**
 * declaration de la base de données Room avec la liste des entités et la version.
 */
@Database(entities = arrayOf(Crise::class), version = 1, exportSchema = false)
public abstract class CriseRoomDatabase : RoomDatabase() {
    abstract fun criseDao(): CriseDao
    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: CriseRoomDatabase? = null
        fun getDatabase(context: Context): CriseRoomDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CriseRoomDatabase::class.java,
                    "base_crise"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}