package com.example.consumopp.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "table_elementos")
class Elemento (val nombre: String, val precio: Long, val cantidad: Int){
    @PrimaryKey (autoGenerate = true) var id: Long = 0
}