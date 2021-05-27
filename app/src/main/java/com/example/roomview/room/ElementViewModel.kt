package com.example.roomview.room

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.roomview.room.Element
import com.example.roomview.room.ElementDatabase
import com.example.roomview.room.ElementRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ElementViewModel(application: Application): AndroidViewModel(application) {

    private val readAllData: LiveData<List<Element>>
    private val repository: ElementRepository

    init {
        val elementDao = ElementDatabase.getDatabase(application).elementDao()
        repository = ElementRepository(elementDao)
        readAllData = repository.readAllDate
    }

    fun addElement(element: Element){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addElement(element)
        }
    }

    fun replaceAllElements(vararg elements: Element){
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertAllElements(*elements)
        }
    }
}