package com.example.migraineapp

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.migraineapp.databinding.ActivityMainBinding
import java.util.*

class Confirmer : AppCompatActivity() {

    lateinit var bouttonRetour : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmer)



        bouttonRetour = findViewById(R.id.buttonRetour)
        val monIntentRetour : Intent =  Intent(this,MainActivity::class.java)
        bouttonRetour.setOnClickListener {
            startActivity(monIntentRetour)
        }
    }
}