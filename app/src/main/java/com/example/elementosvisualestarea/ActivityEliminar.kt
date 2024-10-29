package com.example.elementosvisualestarea

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ActivityEliminar : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_eliminar)

        // Configuración de WindowInsets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainEliminar)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Inicialización del Spinner y del botón
        val spinnerServicioEliminar: Spinner = findViewById(R.id.spinnerServicioEliminar)
        val btnEliminarServicio: Button = findViewById(R.id.btnEliminarServicio)

        // Configuración inicial para deshabilitar el botón
        btnEliminarServicio.isEnabled = false

        // Configuración del Spinner con opciones de servicios
        val servicios = arrayOf("Seleccione un servicio", "Servicio 1", "Servicio 2", "Servicio 3")
        val servicioAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, servicios)
        servicioAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerServicioEliminar.adapter = servicioAdapter

        // Listener para habilitar el botón de eliminar al seleccionar un servicio
        spinnerServicioEliminar.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                // Habilita el botón si la posición seleccionada es distinta a la primera opción
                btnEliminarServicio.isEnabled = position != 0
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                btnEliminarServicio.isEnabled = false
            }
        }

        // Acción del botón de eliminar
        btnEliminarServicio.setOnClickListener {
            val servicioSeleccionado = spinnerServicioEliminar.selectedItem.toString()
            // Lógica para eliminar el servicio seleccionado
            Toast.makeText(this, "Servicio eliminado: $servicioSeleccionado", Toast.LENGTH_SHORT).show()
        }
    }
}
