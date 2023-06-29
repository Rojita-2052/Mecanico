package com.example.mecanico

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(val inspeccionesList: ArrayList<ObtenerInspecciones>):RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
            val patente:TextView = itemView.findViewById(R.id.txtv_patente)
            val marca:TextView = itemView.findViewById(R.id.txtv_marca)
            val color:TextView = itemView.findViewById(R.id.txtv_color)
            val fecha:TextView = itemView.findViewById(R.id.txtv_fecha)
            val kilometraje:TextView = itemView.findViewById(R.id.txtv_kilometraje)
            val motivo:TextView = itemView.findViewById(R.id.txtv_motivo)
            val nombre:TextView = itemView.findViewById(R.id.txtv_nombre)
            val rut:TextView = itemView.findViewById(R.id.txtv_rut)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.lista_item,parent,false)
        return MyViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.patente.text = inspeccionesList[position].patente
        holder.marca.text = inspeccionesList[position].marca
        holder.color.text = inspeccionesList[position].colores
        holder.fecha.text = inspeccionesList[position].date
        holder.kilometraje.text = inspeccionesList[position].kilometraje
        holder.motivo.text = inspeccionesList[position].motivo
        holder.nombre.text = inspeccionesList[position].nombre
        holder.rut.text = inspeccionesList[position].rut
    }
    override fun getItemCount(): Int {
        return inspeccionesList.size
    }
}