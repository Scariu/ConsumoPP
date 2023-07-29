package com.example.consumopp.data

import androidx.lifecycle.LiveData
import com.example.consumopp.data.local.Elemento
import com.example.consumopp.data.local.ElementoDAO

class Repositorio(private val elemetoDAO: ElementoDAO) {
    suspend fun insertarElementos(elemento: Elemento) {
        elemetoDAO.insertElemento(elemento)
    }

    fun getItem(): LiveData<List<Elemento>> {
        return elemetoDAO.getTodosElementos()
    }
}
