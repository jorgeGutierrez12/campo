package com.example.campo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView




class Adapter(private val elementos: MutableList<tarea>) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvCultivo: TextView = view.findViewById(R.id.tvCultivo)
        val tvTipo: TextView = view.findViewById(R.id.tvTipo)
        val btnEliminar = itemView.findViewById<Button>(R.id.btnEliminar)
        val tvFechaRegistro = itemView.findViewById<TextView>(R.id.tvFechaRegistro)
        val imMaiz = itemView.findViewById<ImageView>(R.id.imMaiz)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cardview, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = elementos[position]
        holder.tvCultivo.text = item.Nombre
        holder.tvTipo.text = item.Tipo
        holder.tvFechaRegistro.text = item.fechaRegistro
        when (item.Tipo) {
            "Maíz" -> holder.imMaiz.setImageResource(R.mipmap.maiz)
            "Mezcal" -> holder.imMaiz.setImageResource(R.mipmap.mezcal)
            "Caña" -> holder.imMaiz.setImageResource(R.mipmap.cana)
        }
        holder.btnEliminar.setOnClickListener {
            elementos.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, elementos.size)
        }
    }
        override fun getItemCount(): Int = elementos.size


    }