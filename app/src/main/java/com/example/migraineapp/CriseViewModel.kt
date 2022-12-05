package com.example.migraineapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.util.concurrent.Flow

class CriseViewModel(private val repository: CriseRepository) : ViewModel() {
    // Using LiveData and caching what allCrises returns has several benefits:
    // - We can put an observer on the data (instead of polling for changes) and only update the
    //   the UI when the data actually changes.
    // - Repository is completely separated from the UI through the ViewModel.
    val allCrises: LiveData<List<Crise>> = repository.allCrises
    /**
     * Launching a new coroutine to insert the data in a non-blocking way
     */
    fun insert(crise: Crise) = viewModelScope.launch {
        repository.insert(crise)
    }
}

class CriseViewModelFactory(private val repository: CriseRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CriseViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CriseViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}