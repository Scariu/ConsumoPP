package com.example.consumopp.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.consumopp.data.local.Elemento
import com.example.consumopp.databinding.ItemBinding

class Adapter: RecyclerView.Adapter<Adapter.ViewHolder>() {
    private val listItem = mutableListOf<Elemento>()
    lateinit var binding: ItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listItem[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return listItem.size
    }
    fun setData(listItem : List<Elemento>){
        this.listItem.clear()
        this.listItem.addAll(listItem)
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Elemento) {
            binding.tvItemNombre.text = item.nombre
            binding.tvItemPrecio.text = item.precio.toString()
            binding.tvItemCantidad.text = item.cantidad.toString()
            binding.tvTotalCard.text = (item.precio * item.cantidad).toString()
        }
    }
}