package com.example.mecanico

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*

class Historial : AppCompatActivity() {
    private lateinit var listViewInspecciones: ListView
    private lateinit var database: DatabaseReference
    private lateinit var inspeccionesList: MutableList<Inspeccion>
    private lateinit var adapter: ArrayAdapter<Inspeccion>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historial)

        listViewInspecciones = findViewById(R.id.listViewInspecciones)
        database = FirebaseDatabase.getInstance().getReference("Inspecciones")
        inspeccionesList = mutableListOf()
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, inspeccionesList)
        listViewInspecciones.adapter = adapter

        mostrarInspecciones()
    }

    private fun mostrarInspecciones() {
        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                inspeccionesList.clear()
                for (dataSnapshot in snapshot.children) {
                    val inspeccion = dataSnapshot.getValue(Inspeccion::class.java)
                    if (inspeccion != null) {
                        inspeccionesList.add(inspeccion)
                    }
                }
                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                // Manejar el error en caso de que ocurra
            }
        })
    }
}
