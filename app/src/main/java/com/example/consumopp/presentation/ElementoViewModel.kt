package com.example.consumopp.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.consumopp.data.Repositorio
import com.example.consumopp.data.local.Elemento
import com.example.consumopp.data.local.ElementoDataBase
import kotlinx.coroutines.launch

class ElementoViewModel(application: Application) : AndroidViewModel(application) {
    private val repositorio: Repositorio

    init {
        val dao = ElementoDataBase.getDatabase(application).getElementosDAO()
        repositorio = Repositorio(dao)
    }

    fun getAllElementos(): LiveData<List<Elemento>> = repositorio.getElemento()

    fun insertItem(nombre: String, precio: Long, cantidad: Int) = viewModelScope.launch {
        val elemento = Elemento(nombre, precio, cantidad)
        repositorio.insertarElementos(elemento)
    }
}
