package com.example.mecanico

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Inicio : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var authStateListener: FirebaseAuth.AuthStateListener
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)
        val btnIngresar : Button = findViewById(R.id.btn_ingresar)
        val email : TextView = findViewById(R.id.txt_email)
        val pass : TextView= findViewById<TextView>(R.id.txt_password)
        firebaseAuth = Firebase.auth
        btnIngresar.setOnClickListener()
        {
            if(email.text.isNotEmpty()||pass.text.isNotEmpty()){
                credenciales(email.text.toString(),pass.text.toString())
            }else{
                Toast.makeText(baseContext, "¡Por favor ingresa un email y/o contraseña válido!",Toast.LENGTH_SHORT).show()
            }

        }
    }

    private fun credenciales(email: String, clave: String){
        firebaseAuth.signInWithEmailAndPassword(email,clave).addOnCompleteListener(this) { task ->
            if(task.isSuccessful){
                val user = firebaseAuth.currentUser
                Toast.makeText(baseContext, user?.uid.toString(),Toast.LENGTH_SHORT).show()
                //aquí se va al home activity
            }else{
                Toast.makeText(baseContext, "Error Email/Contraseña incorrectas",Toast.LENGTH_SHORT).show()
            }
        }
    }
}