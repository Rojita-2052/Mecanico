package com.example.mecanico

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.util.Log
import android.view.View

import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
class Registro : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)
        iniciarSpinnerMarca()
        iniciarSpinnerColor()
    }

    fun iniciarSpinnerMarca(){
        val opcionMarca = arrayOf("Seleccionar","Hyundai", "Chevrolet", "Susuki", "Nissan", "Chery")

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, opcionMarca)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        val spinnerMarca = findViewById<Spinner>(R.id.sp_marca)
        spinnerMarca.adapter = adapter
    }
    fun iniciarSpinnerColor() {
        val opcionColor = arrayOf("Seleccionar","Rojo", "Blanco", "Negro", "Verde", "Gris")

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, opcionColor)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        val spinnerColor = findViewById<Spinner>(R.id.sp_colores)
        spinnerColor.adapter = adapter
    }
























       /* spinnerBrands = findViewById(R.id.spinnerBrands)
        spinnerColors = findViewById(R.id.spinnerColors)

        val brands = arrayOf("Marca 1", "Marca 2", "Marca 3") // Ejemplo de datos para el spinner de marcas
        val colors = arrayOf("Color 1", "Color 2", "Color 3") // Ejemplo de datos para el spinner de colores

        val brandAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, brands)
        brandAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerBrands.adapter = brandAdapter

        val colorAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, colors)
        colorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerColors.adapter = colorAdapter*/
    }
