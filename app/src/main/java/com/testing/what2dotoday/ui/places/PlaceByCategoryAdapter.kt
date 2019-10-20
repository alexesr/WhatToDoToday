package com.testing.what2dotoday.ui.places

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.testing.what2dotoday.R


class PlaceByCategoryAdapter(val placesList: ArrayList<PlacesModel>): RecyclerView.Adapter<PlaceByCategoryAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.place_row ,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return placesList.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val row: PlacesModel = placesList[position]

        holder.placeImage.setImageResource(row.image)
        holder.placeTitle.text = row.title
        holder.placeDescription.text = row.description
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var placeImage = itemView.findViewById(R.id.place_image) as ImageView
        var placeTitle = itemView.findViewById(R.id.place_title) as TextView
        var placeDescription = itemView.findViewById(R.id.place_description) as  TextView
    }
}