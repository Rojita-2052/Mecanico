package com.example.mecanico

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*

class Historial : AppCompatActivity() {
    private lateinit var listViewInspecciones: ListView
    private lateinit var searchView: SearchView
    private lateinit var database: DatabaseReference
    private lateinit var inspeccionesList: MutableList<Inspeccion>
    private lateinit var adapter: ArrayAdapter<Inspeccion>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historial)

        listViewInspecciones = findViewById(R.id.listViewInspecciones)
        searchView = findViewById(R.id.searchView)
        database = FirebaseDatabase.getInstance().getReference("Inspecciones")
        inspeccionesList = mutableListOf()
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, inspeccionesList)
        listViewInspecciones.adapter = adapter

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                // Aquí puedes implementar la lógica para buscar en la lista
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                // Aquí puedes implementar la lógica para buscar en la lista a medida que se va escribiendo
                return false
            }
        })

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
