package com.example.mecanico

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent

import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
class Registro : AppCompatActivity() {

    private lateinit var editTextPatent: EditText
    private lateinit var spinnerBrands: Spinner
    private lateinit var spinnerColors: Spinner
    private lateinit var editTextDate: EditText
    private lateinit var editTextMileage: EditText
    private lateinit var checkBoxService: CheckBox
    private lateinit var checkBoxMaintenance: CheckBox
    private lateinit var editTextClientRut: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        spinnerBrands = findViewById(R.id.spinnerBrands)
        spinnerColors = findViewById(R.id.spinnerColors)

        val brands = arrayOf("Marca 1", "Marca 2", "Marca 3") // Ejemplo de datos para el spinner de marcas
        val colors = arrayOf("Color 1", "Color 2", "Color 3") // Ejemplo de datos para el spinner de colores

        val brandAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, brands)
        brandAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerBrands.adapter = brandAdapter

        val colorAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, colors)
        colorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerColors.adapter = colorAdapter
    }
}
