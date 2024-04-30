package com.example.campo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(private val elementos: MutableList<tarea>) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvCultivo: TextView = view.findViewById(R.id.tvCultivo)
        val tvTipo: TextView = view.findViewById(R.id.tvTipo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cardview, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = elementos[position]
        holder.tvCultivo.text = item.Nombre
        holder.tvTipo.text = item.Tipo
    }

    override fun getItemCount(): Int = elementos.size
}
