package com.example.campo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class Adapter(val tareas:List<tarea>): RecyclerView.Adapter<viewholder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        val vista = LayoutInflater.from(parent.context).inflate(
            R.layout.cardview,
            parent,
            false)
        return viewholder(vista)
    }

    override fun getItemCount(): Int = tareas.size

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        holder.tvCultivo.text = tareas[position].Nombre
        holder.tvTipo.text = tareas[position].Tipo

    }

}