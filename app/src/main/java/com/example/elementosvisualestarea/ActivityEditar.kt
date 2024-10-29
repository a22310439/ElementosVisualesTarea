package com.example.elementosvisualestarea

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Calendar

class ActivityEditar : AppCompatActivity() {

    private lateinit var etEditarDescripcion: EditText
    private lateinit var etEditarMonto: EditText
    private lateinit var etEditarFecha: EditText
    private lateinit var spinnerEditarCliente: Spinner
    private lateinit var etEditarComentarios: EditText
    private lateinit var radioGroupEditarEstado: RadioGroup
    private lateinit var btnGuardarCambios: Button
    private lateinit var spinnerServicio: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_editar)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainEditar)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Inicializa las variables
        spinnerServicio = findViewById(R.id.spinnerServicio)
        etEditarDescripcion = findViewById(R.id.etEditarDescripcion)
        etEditarMonto = findViewById(R.id.etEditarMonto)
        etEditarFecha = findViewById(R.id.etEditarFecha)
        spinnerEditarCliente = findViewById(R.id.spinnerEditarCliente)
        etEditarComentarios = findViewById(R.id.etEditarComentarios)
        radioGroupEditarEstado = findViewById(R.id.radioGroupEditarEstado)
        btnGuardarCambios = findViewById(R.id.btnGuardarCambios)

        // Deshabilita todos los elementos al inicio
        habilitarElementos(false)

        // Configuración del selector de servicios con el primer ítem como "Seleccionar servicio:"
        val servicios = arrayOf("Seleccionar servicio:", "Servicio 1", "Servicio 2", "Servicio 3")
        val servicioAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, servicios)
        servicioAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerServicio.adapter = servicioAdapter

        // Listener para habilitar los elementos solo cuando se selecciona un servicio distinto del inicial
        spinnerServicio.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                // Habilitar los elementos solo si se selecciona un servicio diferente de "Seleccionar servicio:"
                habilitarElementos(position != 0)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        // Configuración del campo de fecha
        etEditarFecha.setOnClickListener {
            showDatePickerDialog(etEditarFecha)
        }

        // Configuración del Spinner de Cliente
        val clientes = arrayOf("Cliente 1", "Cliente 2", "Cliente 3")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, clientes)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerEditarCliente.adapter = adapter

        // Configuración del botón Guardar Cambios
        btnGuardarCambios.setOnClickListener {
            guardarCambiosServicio()
        }
    }

    private fun showDatePickerDialog(etEditarFecha: EditText) {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
            val formattedDate = "$selectedDay/${selectedMonth + 1}/$selectedYear"
            etEditarFecha.setText(formattedDate)
        }, year, month, day)

        datePickerDialog.show()
    }

    private fun guardarCambiosServicio() {
        val servicioSeleccionado = spinnerServicio.selectedItem.toString()
        Toast.makeText(this, "Servicio editado: $servicioSeleccionado", Toast.LENGTH_SHORT).show()
    }

    // Método para habilitar o deshabilitar los elementos del formulario
    private fun habilitarElementos(habilitar: Boolean) {
        etEditarDescripcion.isEnabled = habilitar
        etEditarMonto.isEnabled = habilitar
        etEditarFecha.isEnabled = habilitar
        spinnerEditarCliente.isEnabled = habilitar
        etEditarComentarios.isEnabled = habilitar
        radioGroupEditarEstado.isEnabled = habilitar
        btnGuardarCambios.isEnabled = habilitar
    }
}
