package com.example.animal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class AnimalAdapter(val data : List<Animal>, val selectionDone: (Animal) -> Unit) : RecyclerView.Adapter<AnimalAdapter.AnimalHolder>(){

    class AnimalHolder(v: View) : RecyclerView.ViewHolder(v){

        val iView = v.findViewById<ImageView>(R.id.imageView)
        val nametextView = v.findViewById<TextView>(R.id.nameT)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.animal_list_item,parent,false)
        return AnimalHolder(view)
    }

    override fun onBindViewHolder(holder: AnimalHolder, position: Int) {
        val anml = data[position]
        holder.nametextView.text = anml.name
        holder.iView.setImageResource(anml.imageId)

    }

    override fun getItemCount(): Int {
        return data.size
    }

}