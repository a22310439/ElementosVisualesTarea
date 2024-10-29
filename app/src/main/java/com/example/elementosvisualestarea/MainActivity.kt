package com.example.elementosvisualestarea

import android.content.Intent
import android.widget.ImageButton
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnAgregar: ImageButton = findViewById(R.id.btnAgregar)
        val btnEditar: ImageButton = findViewById(R.id.btnEditar)
        val btnEliminar: ImageButton = findViewById(R.id.btnEliminar)
        val btnConsultar: ImageButton = findViewById(R.id.btnConsultar)

        btnAgregar.setOnClickListener {
            val intent = Intent(this, ActivityAgregar::class.java)
            startActivity(intent)
        }

        btnEditar.setOnClickListener {
            val intent = Intent(this, ActivityEditar::class.java)
            startActivity(intent)
        }

        btnEliminar.setOnClickListener {
            val intent = Intent(this, ActivityEliminar::class.java)
            startActivity(intent)
        }

        btnConsultar.setOnClickListener {
            val intent = Intent(this, ActivityConsultar::class.java)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> {
                val intent = Intent(this, ActivityConfiguraciones::class.java)
                startActivity(intent)
                true
            }
            R.id.action_about -> {
                Toast.makeText(this, "Acerca de seleccionada", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_help -> {
                Toast.makeText(this, "Ayuda seleccionada", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}