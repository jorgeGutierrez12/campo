package com.example.campo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.campo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var spinner : Spinner
    lateinit var etNombre : EditText
    lateinit var btGuardar: Button
    lateinit var cultivos: RecyclerView
    lateinit var adapter:Adapter
    private val vmculti:vmCulti by viewModels()
    private lateinit var  binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(CultiFragment())
        binding.bottomNavigationView.setOnItemSelectedListener {

            when (it.itemId)
            {
                R.id.icAPI -> replaceFragment(info())
                R.id.icCultivos -> replaceFragment(CultiFragment())

                else ->{

                }
            }
            true
        }

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
            var tipo = spinner.getSelectedItem().toString();
            var name = etNombre.text.toString()
            vmculti.elementos.add(tarea("$name","$tipo", false))
            adapter.notifyDataSetChanged()
        }

    }

    private fun replaceFragment (fragment: Fragment)
    {
        val fragmentManager = supportFragmentManager
        val fragmentTransition = fragmentManager.beginTransaction()
        fragmentTransition.replace(R.id.frame,fragment)
        fragmentTransition.commit()
    }
}