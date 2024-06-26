package com.example.campo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.activity.viewModels
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class CultiFragment : Fragment() {
    lateinit var spinner: Spinner
    lateinit var etNombre: EditText
    lateinit var btGuardar: Button
    lateinit var cultivos: RecyclerView
    lateinit var adapter: Adapter
    private var param1: String? = null
    private var param2: String? = null
    private val vmculti: vmCulti by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        var view: View? = null
        view = inflater.inflate(R.layout.fragment_culti, container, false)

        etNombre = view.findViewById<EditText>(R.id.etNombre)
        btGuardar = view.findViewById<Button>(R.id.btGuardar)
        spinner = view.findViewById<Spinner>(R.id.spTipos)
        cultivos = view.findViewById<RecyclerView>(R.id.rvCultivo)
        adapter = Adapter(vmculti.elementos)

        cultivos.adapter = adapter
        cultivos.layoutManager = GridLayoutManager(
            requireContext(),
            1,
        )


        val adapterSp: ArrayAdapter<String>
        val listSp: MutableList<String>

        listSp = ArrayList()
        listSp.add("Maíz")
        listSp.add("Mezcal")
        listSp.add("Caña")
        adapterSp = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item, listSp
        )
        adapterSp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.setAdapter(adapterSp)

        btGuardar.setOnClickListener {
            val tipo = spinner.selectedItem.toString()
            val name = etNombre.text.toString()
            vmculti.elementos.add(tarea(name, tipo, false))
            adapter.notifyDataSetChanged()
        }
        return view
    }
}

