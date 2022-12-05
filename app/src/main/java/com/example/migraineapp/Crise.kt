package com.example.migraineapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "table_crise")
data class Crise  (
    @PrimaryKey(autoGenerate = true) val cid: Int,
    @ColumnInfo(name = "date_crise") var date: String?,
    @ColumnInfo(name = "intensite") val  intensite: String?,
    @ColumnInfo(name = "ains") val ains: String?,
    @ColumnInfo(name = "triptans") val  triptans: String?,
    @ColumnInfo(name = "traitement_de_fond") val traitement: String?,
    @ColumnInfo(name = "observations") val observations: String?
) : Serializable


