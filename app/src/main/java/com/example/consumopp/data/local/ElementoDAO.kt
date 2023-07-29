package com.example.consumopp.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ElementoDAO {
    @Insert
    suspend fun insertElemento(elemento: Elemento)

    @Query("SELECT * FROM table_elementos order by id ASC")
    fun getTodosElementos(): LiveData<List<Elemento>>
}