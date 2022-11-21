package com.example.migraineapp

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.migraineapp.databinding.ActivityMainBinding
import java.util.*

const val EXTRA_INTENSITE = "com.example.migraineapp.INTENSITE";
const val EXTRA_AINS = "com.example.migraineapp.AINS";
const val EXTRA_TRIPTANS = "com.example.migraineapp.TRIPTANS";
const val EXTRA_TRAITEMENTDEFONDS = "com.example.migraineapp.TRAITEMENTDEFONDS";
const val EXTRA_OBSERVATIONS = "com.example.migraineapp.OBSERVATIONS";
const val EXTRA_DATE = "com.example.migraineapp.DATE";


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var boutonEnvoyer: Button
    lateinit var dpd: DatePickerDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val intensities = resources.getStringArray(R.array.Intensities)
        val aINSs = resources.getStringArray(R.array.AINS)
        val triptans = resources.getStringArray(R.array.Triptans)
        val traitementDeFonds = resources.getStringArray(R.array.Traitement_de_fond)
        val observations = findViewById<EditText>(R.id.editTextObservations)

        val date = findViewById<Button>(R.id.pickDateBtn)
        val textView = findViewById<TextView>(R.id.date)
        val calendrier = Calendar.getInstance()
        val year = calendrier.get(Calendar.YEAR)
        val month = calendrier.get(Calendar.MONTH)
        val day = calendrier.get(Calendar.DAY_OF_MONTH)

        val spinnerIntensities = findViewById<Spinner>(R.id.spinner_intensities)
        val spinnerAINS = findViewById<Spinner>(R.id.spinner_AINS)
        val spinnerTriptans = findViewById<Spinner>(R.id.spinner_triptans)
        val spinnerTraitementDeFond = findViewById<Spinner>(R.id.spinner_traitement_de_fond)

        boutonEnvoyer = findViewById(R.id.buttonEnvoyer)


        date.setOnClickListener {

            dpd = DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                    // Display Selected date in TextView
                    textView.setText("" + dayOfMonth + ", " + (monthOfYear + 1) + ", " + year)
                },
                year,
                month,
                day
            )
            dpd.show()


        }

        if (spinnerIntensities != null) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, intensities
            )
            spinnerIntensities.adapter = adapter

            spinnerIntensities.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View, position: Int, id: Long
                ) {
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }


            }
        }
        if (spinnerAINS != null) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, aINSs
            )
            spinnerAINS.adapter = adapter

            spinnerAINS.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View, position: Int, id: Long
                ) {
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }


            }
        }

        if (spinnerTriptans != null) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, triptans
            )
            spinnerTriptans.adapter = adapter

            spinnerTriptans.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View, position: Int, id: Long

                ) {
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }


            }
        }

        if (spinnerTraitementDeFond != null) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, traitementDeFonds
            )
            spinnerTraitementDeFond.adapter = adapter
            spinnerTraitementDeFond.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View, position: Int, id: Long

                ) {

                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }
        }
        val envoyerIntent: Intent = Intent(this, Confirmer::class.java)
        fun envoyermessage(): Unit {
            val extras = Bundle()
            val observation = observations.text
            extras.putString(EXTRA_INTENSITE,spinnerIntensities.getSelectedItem().toString())
            extras.putString(EXTRA_AINS,spinnerAINS.getSelectedItem().toString())
            extras.putString(EXTRA_TRIPTANS,spinnerTriptans.getSelectedItem().toString())
            extras.putString(EXTRA_TRAITEMENTDEFONDS,spinnerTraitementDeFond.getSelectedItem().toString())
            extras.putString(EXTRA_OBSERVATIONS,observation.toString())
            extras.putString(EXTRA_DATE,date.text.toString())
            envoyerIntent.putExtras(extras)
            startActivity(envoyerIntent)
        }
        boutonEnvoyer.setOnClickListener{
            envoyermessage()
        }
    }
}




