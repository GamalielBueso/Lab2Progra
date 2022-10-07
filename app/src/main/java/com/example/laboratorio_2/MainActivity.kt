package com.example.laboratorio_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    private lateinit var etnNombre: EditText
    private lateinit var etnEdad: EditText
    private lateinit var etnDepartamento: EditText
    private lateinit var lvNombres: ListView
    private lateinit var tvDatos: TextView

    private var nombres = arrayListOf<String>()
    private var edades = arrayListOf<String>()
    private var departamentos = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etnNombre = findViewById(R.id.etn_Nombre)
        etnEdad = findViewById(R.id.etn_Edad)
        etnDepartamento = findViewById(R.id.etn_Departamentos)
        lvNombres = findViewById(R.id.lv_Nombres)
        tvDatos = findViewById(R.id.tv_Datos)
    }

    fun registrar(v: View){

        val nombre = etnNombre.text.toString()
        val edad = etnEdad.text.toString()
        val departamento = etnDepartamento.text.toString()

        if(!nombre.isEmpty() && !edad.isEmpty() && !departamento.isEmpty()){
            nombres.add(nombre)
            edades.add(edad)
            departamentos.add(departamento)

            val adaptador: ArrayAdapter<String> = ArrayAdapter<String>(this, R.layout.list_item_programacion, nombres)
            lvNombres.adapter = adaptador

            lvNombres.onItemClickListener = object : AdapterView.OnItemClickListener{
                override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    tvDatos.text = "Los datos son: Nombre: ${lvNombres?.getItemAtPosition(position)} " + "Edad: ${edades[position]} " + "Departamento: ${departamentos[position]}"
                }
            }

            etnNombre.setText("")
            etnEdad.setText("")
            etnDepartamento.setText("")

            Toast.makeText(this, "Registro exitoso", Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(this, "Debes llenar todos los campos", Toast.LENGTH_SHORT).show()
        }
    }
}