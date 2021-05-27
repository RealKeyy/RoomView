package com.example.roomview.room

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

class ElementRepository(private val elementDao: ElementDao) {

    val readAllData: LiveData<List<Element>> = elementDao.readAllData()
    val readFirstData: LiveData<List<Element>> = elementDao.readFirstData()

    suspend fun addElement(element: Element){
        elementDao.addElement(element)
    }

    suspend fun replaceElement(element:Element){
        elementDao.replaceElement(element)
    }

    suspend fun updateElement(element: Element){
        elementDao.updateElement(element)
    }

    suspend fun insertAllElements(vararg elements: Element){
        elementDao.replaceAllElements(*elements)
    }
}