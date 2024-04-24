package com.example.campo

import android.annotation.SuppressLint
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
    @SuppressLint("UseRequireInsteadOfGet")
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

        val frag = supportFragmentManager.findFragmentById(R.id.frame)as? CultiFragment
        frag?.let {

        }


        /*
        etNombre = findViewById(R.id.etNombre)
        btGuardar = findViewById(R.id.btGuardar)
        cultivos = findViewById(R.id.rvCultivo)
        spinner = findViewById(R.id.spTipos)

         */


    }

    private fun replaceFragment (fragment: Fragment)
    {
        val fragmentManager = supportFragmentManager
        val fragmentTransition = fragmentManager.beginTransaction()
        fragmentTransition.replace(R.id.frame,fragment)
        fragmentTransition.commit()
    }
}