package com.example.consumopp.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "table_elementos")
class Elemento (private val nombre: String, private val precio: Long, private val cantidad: Int){
    @PrimaryKey (autoGenerate = true) var id: Long = 0
}