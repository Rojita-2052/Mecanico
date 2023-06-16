package com.example.mecanico

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import com.example.mecanico.databinding.ActivityHistorialBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class Historial : AppCompatActivity() {
    private lateinit var binding: ActivityHistorialBinding
    private lateinit var datebase: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityHistorialBinding.inflate(layoutInflater)
        setContentView(binding.root)



                val intent= Intent(applicationContext, Home::class.java)
                startActivity(intent)

            }
        }



