package com.example.mecanico

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import android.widget.SearchView

class Historial : AppCompatActivity() {
    private lateinit var recyclerViewInspecciones: RecyclerView
    private lateinit var searchView: SearchView
    private lateinit var database: DatabaseReference
    private lateinit var inspeccionesList: MutableList<Inspeccion>
    private lateinit var adapter: Adaptador

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historial)

        recyclerViewInspecciones = findViewById(R.id.recyclerViewInspecciones)
        this.searchView = findViewById(R.id.searchView)
        database = FirebaseDatabase.getInstance().getReference("Inspecciones")
        inspeccionesList = mutableListOf()
        adapter = Adaptador(this, inspeccionesList)

        recyclerViewInspecciones.layoutManager = LinearLayoutManager(this)
        recyclerViewInspecciones.adapter = adapter

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                // Aquí puedes implementar la lógica para realizar la búsqueda al presionar el botón "Siguiente"
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                // Aquí puedes implementar la lógica para buscar a medida que se va escribiendo
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
                Log.d("TAG", "Cantidad de inspecciones: ${inspeccionesList.size}")
                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("TAG", "Error al obtener inspecciones: ${error.message}")
            }
        })
    }
}

