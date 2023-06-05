package com.example.mecanico

import android.content.Intent
import android.opengl.GLES30
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
class Inicio : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var authStateListener: FirebaseAuth.AuthStateListener

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)
        firebaseAuth = Firebase.auth
    }


    fun enviar(view: View)
    {
        val email : EditText = findViewById(R.id.txt_email)
        val pass : EditText= findViewById(R.id.txt_password)

        if(email.text.isNotEmpty()||pass.text.isNotEmpty()){
            credenciales(email.text.toString(),pass.text.toString())
        }else{
            email.error = "Campo requerido"
            pass.error = "Campo requerido"
            Toast.makeText(baseContext, "¡Por favor ingresa un email y/o contraseña válido!",Toast.LENGTH_LONG).show()
        }
    }
    private fun credenciales(email: String, clave: String){
        firebaseAuth.signInWithEmailAndPassword(email,clave).addOnCompleteListener(this) { task ->
            if(task.isSuccessful){
                val user = firebaseAuth.currentUser
                //aquí se va al home activity
                val intent= Intent(applicationContext, Home::class.java).apply {
                    putExtra("email", email)
                }
                startActivity(intent)
            }else{
                Toast.makeText(baseContext, "Error Email/Contraseña incorrectas",Toast.LENGTH_SHORT).show()
            }
        }
    }
}