package com.example.migraineapp

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CriseDao {
    @Query("SELECT * FROM table_crise ORDER BY date_crise ASC")
    fun getChronologicalCrises(): Flow<List<Crise>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(crise: Crise)

    @Query("DELETE FROM table_crise")
    suspend fun deleteAll()
}