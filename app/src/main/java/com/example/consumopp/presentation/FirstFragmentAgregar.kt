package com.example.consumopp.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.consumopp.R
import com.example.consumopp.data.local.Elemento
import com.example.consumopp.databinding.FragmentFirstAgregarBinding

class FirstFragmentAgregar : Fragment() {
    lateinit var binding: FragmentFirstAgregarBinding
    private val viewModel: ElementoViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstAgregarBinding.inflate(layoutInflater)
        initListeners()
        return binding.root
    }

    private fun initListeners() {
        binding.btnGuardar.setOnClickListener {
            getData()
        }
        binding.btnLista.setOnClickListener{
            findNavController().navigate(R.id.action_firstFragmentAgregar_to_secondFragmentList)
        }
    }

    private fun getData() {
        val nombre = binding.etNombre.text.toString()
        val precio = binding.etPrecio.text.toString().toLong()
        val cantidad = binding.etCantidad.text.toString().toInt()

        viewModel.insertItem(nombre, precio, cantidad)
    }
}