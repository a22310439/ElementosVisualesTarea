package com.example.elementosvisualestarea

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ActivityConsultar : AppCompatActivity() {

    private lateinit var spinnerServicioConsultar: Spinner
    private lateinit var tvDetallesServicio: TextView
    private lateinit var tvDescripcion: TextView
    private lateinit var etDescripcion: EditText
    private lateinit var etMonto: EditText
    private lateinit var tvMonto: TextView
    private lateinit var etFecha: EditText
    private lateinit var tvFecha: TextView
    private lateinit var spinnerCliente: Spinner
    private lateinit var tvCliente: TextView
    private lateinit var etComentarios: EditText
    private lateinit var tvComentarios: TextView
    private lateinit var radioGroupEstado: RadioGroup
    private lateinit var tvEstado: TextView
    private lateinit var radioPendiente: RadioButton
    private lateinit var radioTerminado: RadioButton
    private lateinit var checkBoxPagado: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_consultar)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainConsultar)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Inicializar los elementos
        spinnerServicioConsultar = findViewById(R.id.spinnerServicioConsultar)
        tvDetallesServicio = findViewById(R.id.tvDetallesServicio)
        tvDescripcion = findViewById(R.id.tvDescripcion)
        etDescripcion = findViewById(R.id.etDescripcion)
        tvMonto = findViewById(R.id.tvMonto)
        etMonto = findViewById(R.id.etMonto)
        tvFecha = findViewById(R.id.tvFecha)
        etFecha = findViewById(R.id.etFecha)
        tvCliente = findViewById(R.id.tvCliente)
        spinnerCliente = findViewById(R.id.spinnerCliente)
        tvComentarios = findViewById(R.id.tvComentarios)
        etComentarios = findViewById(R.id.etComentarios)
        tvEstado = findViewById(R.id.tvEstado)
        radioGroupEstado = findViewById(R.id.radioGroupEstado)
        radioPendiente = findViewById(R.id.radioPendiente)
        radioTerminado = findViewById(R.id.radioTerminado)
        checkBoxPagado = findViewById(R.id.checkBoxPagado)

        // Configurar el Spinner con una lista de servicios
        val servicios = arrayOf("Seleccione un servicio", "Servicio 1", "Servicio 2", "Servicio 3")
        val servicioAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, servicios)
        servicioAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerServicioConsultar.adapter = servicioAdapter

        // Configurar el listener para el Spinner
        spinnerServicioConsultar.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                // Solo mostrar los elementos si no se selecciona la opción predeterminada (por ejemplo, posición 0)
                if (position != 0) {
                    mostrarElementos()
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }

    // Método para mostrar los elementos
    private fun mostrarElementos() {
        tvDescripcion.visibility = View.VISIBLE
        etDescripcion.visibility = View.VISIBLE
        tvMonto.visibility = View.VISIBLE
        etMonto.visibility = View.VISIBLE
        tvFecha.visibility = View.VISIBLE
        etFecha.visibility = View.VISIBLE
        tvCliente.visibility = View.VISIBLE
        spinnerCliente.visibility = View.VISIBLE
        tvComentarios.visibility = View.VISIBLE
        etComentarios.visibility = View.VISIBLE
        tvEstado.visibility = View.VISIBLE
        radioGroupEstado.visibility = View.VISIBLE
        radioPendiente.visibility = View.VISIBLE
        radioTerminado.visibility = View.VISIBLE
        checkBoxPagado.visibility = View.VISIBLE
    }
}