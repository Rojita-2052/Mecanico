package com.example.mecanico

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private var inspeccionesList: ArrayList<ObtenerInspecciones>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val patente: TextView = itemView.findViewById(R.id.txtv_patente)
        val marca: TextView = itemView.findViewById(R.id.txtv_marca)
        val color: TextView = itemView.findViewById(R.id.txtv_color)
        val fecha: TextView = itemView.findViewById(R.id.txtv_fecha)
        val kilometraje: TextView = itemView.findViewById(R.id.txtv_kilometraje)
        val motivo: TextView = itemView.findViewById(R.id.txtv_motivo)
        val nombre: TextView = itemView.findViewById(R.id.txtv_nombre)
        val rut: TextView = itemView.findViewById(R.id.txtv_rut)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.lista_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val inspeccion = inspeccionesList[position]
        holder.patente.text = inspeccion.patente
        holder.marca.text = inspeccion.marca
        holder.color.text = inspeccion.colores
        holder.fecha.text = inspeccion.date
        holder.kilometraje.text = inspeccion.kilometraje
        holder.motivo.text = inspeccion.motivo
        holder.nombre.text = inspeccion.nombre
        holder.rut.text = inspeccion.rut
    }

    override fun getItemCount(): Int {
        return inspeccionesList.size
    }

    fun setData(data: ArrayList<ObtenerInspecciones>) {
        inspeccionesList = data
        notifyDataSetChanged()
    }
}
