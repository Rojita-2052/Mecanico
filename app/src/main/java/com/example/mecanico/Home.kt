package com.example.mecanico

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import androidx.appcompat.app.AlertDialog
import android.os.Handler
class Home : AppCompatActivity() {
    private lateinit var bdAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val btnRegistro: Button = findViewById(R.id.btn_registrar)
        val btnHistorial: Button = findViewById(R.id.btn_historial)
        val btnSalir: Button = findViewById(R.id.btn_salir)
        bdAuth = Firebase.auth
        btnRegistro.setOnClickListener {
            val intent = Intent(applicationContext, Registro::class.java)
            startActivity(intent)
        }
        btnHistorial.setOnClickListener {
            val intent = Intent(applicationContext, Historial::class.java)
            startActivity(intent)
        }
        btnSalir.setOnClickListener {
            mostrarDialogoSalir()
        }
    }
    override fun onBackPressed() {
        mostrarDialogoSalir()
    }
    private fun mostrarDialogoSalir() {
        AlertDialog.Builder(this)
            .setTitle("Salir")
            .setMessage("¿Estás seguro que deseas salir de la sesion?")
            .setPositiveButton("Sí") { dialog, which ->
                bdAuth.signOut()
                val intent = Intent(applicationContext, Inicio::class.java)
                startActivity(intent)
                finish()
            }
            .setNegativeButton("No", null)
            .show()
    }
}
class SplashActivity : AppCompatActivity() {

    private val SPLASH_DELAY: Long = 2000 // 2 segundos

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            val intent = Intent(this@SplashActivity, Inicio::class.java)
            startActivity(intent)
            finish()
        }, SPLASH_DELAY)
    }
}
