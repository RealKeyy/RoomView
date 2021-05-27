package com.example.roomview.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Element::class], version = 1, exportSchema = false)
abstract class ElementDatabase: RoomDatabase() {

    abstract fun elementDao():ElementDao

    companion object{
        @Volatile
        private var INSTANCE: ElementDatabase? = null

        fun getDatabase(context: Context): ElementDatabase{
            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                        context.applicationContext,
                        ElementDatabase::class.java,
                        "user_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}