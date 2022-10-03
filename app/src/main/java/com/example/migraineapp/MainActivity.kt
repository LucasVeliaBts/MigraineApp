package com.example.migraineapp

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intensities = resources.getStringArray(R.array.Intensities)

        val AINS = resources.getStringArray(R.array.AINS)
        val triptans = resources.getStringArray(R.array.Triptans)
        val traitement_de_fond = resources.getStringArray(R.array.Traitement_de_fond)
        val mPickTimeBtn = findViewById<Button>(R.id.pickDateBtn)
        val textView     = findViewById<TextView>(R.id.dateTv)

        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        mPickTimeBtn.setOnClickListener {

            val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                // Display Selected date in TextView
                textView.setText("" + dayOfMonth + ", " + (monthOfYear+1) + ", " + year)
            }, year, month, day)
            dpd.show()


        }
        val spinnerIntensities = findViewById<Spinner>(R.id.spinner_intensities)
        if (spinnerIntensities != null) {
            val adapter = ArrayAdapter(this,
                android.R.layout.simple_spinner_item, intensities)
            spinnerIntensities.adapter = adapter

            spinnerIntensities.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }


            }
        }
        val spinnerAINS = findViewById<Spinner>(R.id.spinner_AINS)
        if (spinnerAINS != null) {
            val adapter = ArrayAdapter(this,
                android.R.layout.simple_spinner_item, AINS )
            spinnerAINS.adapter = adapter

            spinnerAINS.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }


            }
        }
        val spinnerTriptans = findViewById<Spinner>(R.id.spinner_triptans)
        if (spinnerTriptans != null) {
            val adapter = ArrayAdapter(this,
                android.R.layout.simple_spinner_item, triptans)
            spinnerTriptans.adapter = adapter

            spinnerTriptans.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }


            }
        }
        val spinnertraitementdefond = findViewById<Spinner>(R.id.spinner_traitement_de_fond)
        if (spinnertraitementdefond != null) {
            val adapter = ArrayAdapter(this,
                android.R.layout.simple_spinner_item, traitement_de_fond)
            spinnertraitementdefond.adapter = adapter

            spinnertraitementdefond.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }


            }
        }
    }
}