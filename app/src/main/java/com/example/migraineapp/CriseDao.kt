package com.example.migraineapp

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query



@Dao
interface CriseDao {
    @Query("SELECT * FROM table_crise ORDER BY date_crise ASC")
    fun getChronologicalCrises(): LiveData<List<Crise>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(crise: Crise)

    @Query("DELETE FROM table_crise")
    suspend fun deleteAll()
}