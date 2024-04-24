package com.example.campo

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment

import com.example.campo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
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




    }

    private fun replaceFragment (fragment: Fragment)
    {
        val fragmentManager = supportFragmentManager
        val fragmentTransition = fragmentManager.beginTransaction()
        fragmentTransition.replace(R.id.frame,fragment)
        fragmentTransition.commit()
    }
}