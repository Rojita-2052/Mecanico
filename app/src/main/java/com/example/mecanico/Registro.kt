package com.example.mecanico

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import com.example.mecanico.databinding.ActivityRegistroBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class Registro : AppCompatActivity() {
    private lateinit var binding: ActivityRegistroBinding
    private lateinit var datebase: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        iniciarSpinnerMarca()
        iniciarSpinnerColor()

        binding.btnRegistarInspeccion.setOnClickListener(){
            val patente     =binding.txtPatente.text.toString()
            val marca       =binding.spMarca.adapter.toString()
            val colores     =binding.spColores.adapter.toString()
            val date        =binding.txtDate.text.toString()
            val kilometraje =binding.txtKilometraje.text.toString()
            val motivo      =binding.rgMotivo.checkedRadioButtonId.toString()
            val rut         =binding.txtRut.text.toString()
            val nombre      =binding.txtNombre.text.toString()

            datebase= FirebaseDatabase.getInstance().getReference("Inspecciones")
            val inspecion=Inspeccion(patente,marca,colores,date,kilometraje,motivo,rut,nombre)
            datebase.child(rut).setValue(inspecion).addOnSuccessListener {
                binding.txtPatente.text.clear()
                binding.txtDate.text.clear()
                binding.txtKilometraje.text.clear()
                binding.txtRut.text.clear()
                binding.txtNombre.text.clear()

                val intent= Intent(applicationContext, Home::class.java)
                startActivity(intent)

            }
        }
    }

    fun iniciarSpinnerMarca(){
        val opcionMarca = arrayOf("Hyundai", "Chevrolet", "Susuki", "Nissan", "Chery")

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, opcionMarca)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        val spinnerMarca = findViewById<Spinner>(R.id.sp_marca)
        spinnerMarca.adapter = adapter
    }
    fun iniciarSpinnerColor() {
        val opcionColor = arrayOf("Rojo", "Blanco", "Negro", "Verde", "Gris")

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, opcionColor)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        val spinnerColor = findViewById<Spinner>(R.id.sp_colores)
        spinnerColor.adapter = adapter
    }
}
