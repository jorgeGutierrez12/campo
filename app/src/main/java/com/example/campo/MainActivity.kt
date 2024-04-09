package com.example.campo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var spinner : Spinner
    lateinit var etNombre : EditText
    lateinit var btGuardar: Button
    lateinit var cultivos: RecyclerView
    lateinit var adapter:Adapter

    private val vmculti:vmCulti by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etNombre = findViewById(R.id.etNombre)
        btGuardar = findViewById(R.id.btGuardar)
        cultivos = findViewById(R.id.rvCultivo)
        spinner = findViewById(R.id.spTipos)

        adapter = Adapter(vmculti.elementos)

        cultivos.adapter = adapter
        cultivos.layoutManager = GridLayoutManager(this,
            1)

        val adapterSp: ArrayAdapter<String>
        val listSp: MutableList<String>

        listSp = ArrayList()
        listSp.add("Maíz")
        listSp.add("Mezcal")
        listSp.add("Caña")
        adapterSp = ArrayAdapter(
            applicationContext,
            android.R.layout.simple_spinner_item, listSp
        )
        adapterSp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.setAdapter(adapterSp)

        btGuardar.setOnClickListener {
            var maiz = "Maíz"
            var tipo = spinner.getSelectedItem().toString();
            var name = etNombre.text.toString()
            vmculti.elementos.add(tarea("$name","$tipo", false))
            adapter.notifyDataSetChanged()
            if (tipo = maiz)
            {

            }
        }

    }
}