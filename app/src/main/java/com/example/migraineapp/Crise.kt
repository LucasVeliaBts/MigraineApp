package com.example.migraineapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_crise")
data class Crise(
    @PrimaryKey(autoGenerate = true) val cid: Int =0,
    @ColumnInfo(name = "date_crise") var date: String?,
    @ColumnInfo(name = "intensite") val intensite: String?,
    @ColumnInfo(name = "ains") var ains: String?,
    @ColumnInfo(name = "traitement_de_fond") val traitement_de_fond: String?,
    @ColumnInfo(name = "triptans") val triptans: String?

)