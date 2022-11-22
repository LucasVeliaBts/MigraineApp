package com.example.migraineapp

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class Confirmer : AppCompatActivity() {

    lateinit var bouttonModifier : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmer)

        val selectionDate = intent.getStringExtra("EXTRA_DATE")
        val selectionIntensite = intent.getStringExtra("EXTRA_INTENSITE")
        val selectionAINS = intent.getStringExtra("EXTRA_AINS")
        val selectionTriptan = intent.getStringExtra("EXTRA_TRIPTANS")
        val selectionTraitementDeFonds = intent.getStringExtra("EXTRA_TRAITEMENTDEFONDS")
        val selectionObservation = intent.getStringExtra("EXTRA_OBSERVATIONS")


        val date = findViewById<TextView>(R.id.date).apply {
            text = selectionDate
        }

        val intensite = findViewById<TextView>(R.id.textViewIntensiteSelection).apply {
            text = selectionIntensite
        }

        val aINS = findViewById<TextView>(R.id.textViewAINSSelection).apply {
            text = selectionAINS
        }

        val triptans = findViewById<TextView>(R.id.textViewTriptansSelection).apply {
            text = selectionTriptan
        }

        val traitementDeFonds = findViewById<TextView>(R.id.textViewTraitementDeFondSelection).apply {
            text = selectionTraitementDeFonds
        }

        val observation = findViewById<TextView>(R.id.textViewObservationsSelection).apply {
            text = selectionObservation
        }


        bouttonModifier = findViewById(R.id.buttonModifier)
        val retourIntent : Intent =  Intent(this,MainActivity::class.java)
        bouttonModifier.setOnClickListener {
            startActivity(retourIntent)
        }
    }
}