package com.example.migraineapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CriseActivity : AppCompatActivity() {

    private val criseViewModel: CriseViewModel by viewModels {
        CriseViewModelFactory((application as CrisesApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.crises_activity)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = CriseListAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        criseViewModel.allCrises.observe(this, Observer { crises ->
            // Update the cached copy of the crises in the adapter.
            crises?.let { adapter.submitList(it) }
        })
    }
}