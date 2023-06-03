package com.example.mecanico

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Home : AppCompatActivity() {
    private lateinit var bdAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val btnRegistro: Button= findViewById(R.id.btn_registrar)
        val btnSalir: Button= findViewById(R.id.btn_salir)
        bdAuth = Firebase.auth
         btnRegistro.setOnClickListener(){
             val intent= Intent(applicationContext, Registro::class.java)
             startActivity(intent)
         }

         btnSalir.setOnClickListener(){
            bdAuth.signOut()
             val intent= Intent(applicationContext, Inicio::class.java)
             startActivity(intent)
        }



    }
}