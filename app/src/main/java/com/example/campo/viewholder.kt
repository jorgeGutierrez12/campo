package com.example.campo

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class viewholder(itemView:View) : RecyclerView.ViewHolder(itemView) {
    val tvCultivo = itemView.findViewById<TextView>(R.id.tvCultivo)
    val tvTipo = itemView.findViewById<TextView>(R.id.tvTipo)
    val btnEliminar = itemView.findViewById<Button>(R.id.btnEliminar)
    val tvFechaRegistro = itemView.findViewById<TextView>(R.id.tvFechaRegistro)
    val imMaiz = itemView.findViewById<ImageView>(R.id.imMaiz)
}