package com.example.migraineapp

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.migraineapp.databinding.ActivityMainBinding
import java.util.*


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val intensities = resources.getStringArray(R.array.Intensities)
        val aINS = resources.getStringArray(R.array.AINS)
        val triptans = resources.getStringArray(R.array.Triptans)
        val traitementDeFond = resources.getStringArray(R.array.Traitement_de_fond)
        val mPickTimeBtn = findViewById<Button>(R.id.pickDateBtn)
        val textView = findViewById<TextView>(R.id.dateTv)
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)
        val spinnerIntensities = findViewById<Spinner>(R.id.spinner_intensities)
        val spinnerAINS = findViewById<Spinner>(R.id.spinner_AINS)
        val spinnerTriptans = findViewById<Spinner>(R.id.spinner_triptans)
        val spinnertraitementdefond = findViewById<Spinner>(R.id.spinner_traitement_de_fond)
        var IntensiteSelection = spinnerIntensities.getSelectedItem()
        var AINSSelection = spinnerAINS.getSelectedItem()
        var TriptansSelection = spinnerTriptans.getSelectedItem()
        var TraitementdefondSelection = spinnertraitementdefond.getSelectedItem()

        mPickTimeBtn.setOnClickListener {

            val dpd = DatePickerDialog(
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
            IntensiteSelection = adapter

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
                android.R.layout.simple_spinner_item, aINS
            )
            spinnerAINS.adapter = adapter
            AINSSelection = adapter

            spinnerAINS.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View, position: Int, id: Long
                )
                {
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
            TriptansSelection = adapter

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

        if (spinnertraitementdefond != null) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, traitementDeFond
            )
            spinnertraitementdefond.adapter = adapter
            TraitementdefondSelection = adapter

            spinnertraitementdefond.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View, position: Int, id: Long

                )
                {
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }
        }

    }
}




