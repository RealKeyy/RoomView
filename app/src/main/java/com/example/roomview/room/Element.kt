package com.example.roomview.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "element_table")
data class Element (
        @PrimaryKey(autoGenerate = true)
        val id: Int,
        val number: Int,
        val priority: Int
)