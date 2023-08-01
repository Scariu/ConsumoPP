package com.example.consumopp.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.clearFragmentResult
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.consumopp.R
import com.example.consumopp.databinding.FragmentSecondListBinding
import kotlinx.coroutines.launch

class SecondFragmentList : Fragment() {
    lateinit var binding: FragmentSecondListBinding
    private val viewModel: ElementoViewModel by activityViewModels()
    private val adapter = Adapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondListBinding.inflate(layoutInflater)
        initAdapter()
        initListeners()
        return binding.root
    }

    private fun initListeners() {
        binding.floabtnDelete.setOnClickListener {
            deleteAll()
        }
    }

    private fun initAdapter() {
        viewModel.getAllElementos().observe(viewLifecycleOwner) {
            adapter.setData(it)
        }
        binding.recyclerViewSecondFragment.adapter = adapter
    }

    private fun deleteAll() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.deleteElementoView()
            findNavController().navigate(R.id.action_secondFragmentList_self)
        }
    }
}