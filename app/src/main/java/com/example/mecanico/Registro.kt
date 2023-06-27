package com.example.mecanico

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
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

        binding.btnRegistarInspeccion.setOnClickListener {
            val patente     =binding.txtPatente.text.toString()
            val marca       =binding.txtMarca.text.toString()
            val colores     =binding.txtColor.text.toString()
            val date        =binding.txtDate.text.toString()
            val kilometraje =binding.txtKilometraje.text.toString()
            val motivo      =binding.txtMotivo.text.toString()
            val rut         =binding.txtRut.text.toString()
            val nombre      =binding.txtNombre.text.toString()

            datebase= FirebaseDatabase.getInstance().getReference("Inspecciones")
            val inspecion=Inspeccion(
                patente,
                marca,
                colores,
                date,
                kilometraje,
                motivo,
                rut,
                nombre,
            )
            datebase.child(rut).setValue(inspecion).addOnSuccessListener {
                binding.txtPatente.text.clear()
                binding.txtMarca.text.clear()
                binding.txtColor.text.clear()
                binding.txtDate.text.clear()
                binding.txtKilometraje.text.clear()
                binding.txtMotivo.text.clear()
                binding.txtRut.text.clear()
                binding.txtNombre.text.clear()

                val intent= Intent(applicationContext, Home::class.java)
                startActivity(intent)
                Toast.makeText(baseContext, "¡Inspección registrada!",Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun Inspeccion(
        patente: String,
        marca: String,
        colores: String,
        date: String,
        kilometraje: String,
        motivo: String,
        rut: String,
        nombre: String
    ) {

    }

}
