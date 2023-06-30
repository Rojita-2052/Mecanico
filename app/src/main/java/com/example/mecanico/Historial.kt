package com.example.mecanico
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import androidx.appcompat.widget.SearchView
import android.widget.Toast

class Historial : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var inspeccionsArrayList: ArrayList<ObtenerInspecciones>
    private lateinit var database: DatabaseReference
    private lateinit var searchView: SearchView
    private lateinit var adapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historial)

        recyclerView = findViewById(R.id.lista_inspecciones)
        recyclerView.layoutManager = LinearLayoutManager(this)

        inspeccionsArrayList = arrayListOf()
        adapter = MyAdapter(inspeccionsArrayList)
        recyclerView.adapter = adapter


        database = FirebaseDatabase.getInstance().getReference("Inspecciones")
        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (dataSnapShot in snapshot.children) {
                        val inspecciones = dataSnapShot.getValue(ObtenerInspecciones::class.java)
                        if (!inspeccionsArrayList.contains(inspecciones)) {
                            inspeccionsArrayList.add(inspecciones!!)
                        }
                    }
                    adapter.notifyDataSetChanged()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(
                    this@Historial,
                    error.toString(),
                    Toast.LENGTH_SHORT
                ).show()
            }
        })

        searchView = findViewById(R.id.searchView)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                searchView.clearFocus()
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                val filteredList = ArrayList<ObtenerInspecciones>()

                for (inspeccion in inspeccionsArrayList) {
                    if (inspeccion.nombre?.toLowerCase()?.contains(newText.toLowerCase()) == true ||
                        inspeccion.patente?.toLowerCase()?.contains(newText.toLowerCase()) == true ||
                        inspeccion.rut?.toLowerCase()?.contains(newText.toLowerCase()) == true ||
                        inspeccion.marca?.toLowerCase()?.contains(newText.toLowerCase()) == true ||
                        inspeccion.motivo?.toLowerCase()?.contains(newText.toLowerCase()) == true ||
                        inspeccion.kilometraje?.toLowerCase()?.contains(newText.toLowerCase()) == true ||
                        inspeccion.date?.toLowerCase()?.contains(newText.toLowerCase()) == true ||
                        inspeccion.colores?.toLowerCase()?.contains(newText.toLowerCase()) == true
                    ) {
                        filteredList.add(inspeccion)
                    }
                }

                adapter.setData(filteredList)
                adapter.notifyDataSetChanged()

                return true
            }
        })
    }
}
