package com.example.elementosvisualestarea

import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class ActivityConfiguraciones : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configuraciones)

        val textViewConfig: TextView = findViewById(R.id.textViewConfig)
        val btnPopup: Button = findViewById(R.id.btnPopup)
        val autoCompleteTextView: AutoCompleteTextView = findViewById(R.id.autoCompleteTextView)
        val toggleButton: ToggleButton = findViewById(R.id.toggleButton)

        // Registrar el TextView para el menú contextual
        registerForContextMenu(textViewConfig)

        // Configurar el botón para mostrar el menú emergente
        btnPopup.setOnClickListener { view ->
            showPopupMenu(view)
        }

        // Configurar el AutoCompleteTextView con sugerencias
        val opciones = arrayOf("Opción 1", "Opción 2", "Opción 3", "Opción 4")
        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, opciones)
        autoCompleteTextView.setAdapter(adapter)

        // Configurar el ToggleButton
        toggleButton.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                Toast.makeText(this, "ToggleButton: Encendido", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "ToggleButton: Apagado", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Método para mostrar el menú emergente
    private fun showPopupMenu(view: View) {
        val popupMenu = PopupMenu(this, view)
        popupMenu.menuInflater.inflate(R.menu.menu_emergente, popupMenu.menu)

        // Manejar la selección de ítems del menú emergente
        popupMenu.setOnMenuItemClickListener { item: MenuItem ->
            when (item.itemId) {
                R.id.action_option1 -> {
                    Toast.makeText(this, "Opción 1 seleccionada", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.action_option2 -> {
                    Toast.makeText(this, "Opción 2 seleccionada", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.action_option3 -> {
                    Toast.makeText(this, "Opción 3 seleccionada", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }

        // Mostrar el menú emergente
        popupMenu.show()
    }

    // Inflar el menú contextual
    override fun onCreateContextMenu(menu: ContextMenu, v: View, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.menu_contextual, menu)
    }

    // Manejar la selección de ítems del menú contextual
    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_edit -> {
                Toast.makeText(this, "Editar seleccionado", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_delete -> {
                Toast.makeText(this, "Eliminar seleccionado", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_share -> {
                Toast.makeText(this, "Compartir seleccionado", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onContextItemSelected(item)
        }
    }
}
