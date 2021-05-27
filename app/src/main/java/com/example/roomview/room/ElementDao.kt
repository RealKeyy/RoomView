package com.example.roomview.room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ElementDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addElement(element: Element)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun replaceElement(element: Element)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun replaceAllElements(vararg elements: Element)

    @Update
    suspend fun updateElement(element: Element)

    @Query("SELECT 0 FROM element_table ORDER BY id ASC")
    fun readFirstData(): LiveData<List<Element>>

    @Query("SELECT * FROM element_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Element>>
}