package com.example.elementosvisualestarea

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Calendar

class ActivityAgregar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_agregar)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainAgregar)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etFecha: EditText = findViewById(R.id.etFecha)
        etFecha.setOnClickListener {
            showDatePickerDialog(etFecha)
        }

        val spinnerCliente: Spinner = findViewById(R.id.spinnerCliente)
        val clientes = arrayOf("Cliente 1", "Cliente 2", "Cliente 3")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, clientes)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerCliente.adapter = adapter

        // Configuración del botón Guardar
        val btnGuardar: Button = findViewById(R.id.btnGuardar)
        btnGuardar.setOnClickListener{
            // Guardar la información ya sea en base de datos o localmente
        }
    }

    private fun showDatePickerDialog(etFecha: EditText) {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
            // Formato de fecha
            val formattedDate = "$selectedDay/${selectedMonth + 1}/$selectedYear"
            etFecha.setText(formattedDate)
        }, year, month, day)

        datePickerDialog.show()
    }
}