package com.example.mecanico

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import android.widget.SearchView
import android.widget.Toast

class Historial : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var inspeccionsArrayList: ArrayList<ObtenerInspecciones>
    private lateinit var database: DatabaseReference
    private lateinit var searchView: SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historial)

       recyclerView = findViewById(R.id.lista_inspecciones)
       recyclerView.layoutManager = LinearLayoutManager(this)

       inspeccionsArrayList= arrayListOf()

       database = FirebaseDatabase.getInstance().getReference("Inspecciones")
       database.addValueEventListener(object :ValueEventListener{
           override fun onDataChange(snapshot: DataSnapshot) {
               if(snapshot.exists()){
                   for(dataSnapShot in snapshot.children){
                       val inspecciones = dataSnapShot.getValue(ObtenerInspecciones::class.java)
                       if(!inspeccionsArrayList.contains(inspecciones)){
                           inspeccionsArrayList.add(inspecciones!!)
                       }
                   }
                   recyclerView.adapter = MyAdapter(inspeccionsArrayList)
               }
           }
           override fun onCancelled(error: DatabaseError) {
               Toast.makeText(this@Historial,error.toString(),Toast.LENGTH_SHORT).show()
           }
       })
        /*searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                searchView.clearFocus()
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                // Aquí puedes implementar la lógica para buscar a medida que se va escribiendo
                return false
            }
        })*/

    }
}

