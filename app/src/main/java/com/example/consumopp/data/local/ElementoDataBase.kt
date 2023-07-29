package com.example.consumopp.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Elemento::class], version = 1)
abstract class ElementoDataBase : RoomDatabase() {

    abstract fun getElementosDAO(): ElementoDAO

    companion object {
        @Volatile
        private var INSTANCE: ElementoDataBase? = null

        fun getDatabase(context: Context): ElementoDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ElementoDataBase::class.java,
                    "elementos_database"
                ).build()

                INSTANCE = instance
                return instance
            }
        }
    }
}
