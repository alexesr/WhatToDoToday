package com.testing.what2dotoday.ui.places

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.ImageView
import android.widget.TextView
import android.widget.ImageButton
import androidx.recyclerview.widget.RecyclerView
import com.testing.what2dotoday.R
import android.util.Log
import android.widget.Button
import android.widget.TableLayout
import com.google.android.material.tabs.TabLayout

class PlaceBySearchAdapter(val placesList: ArrayList<PlacesModel>, val tabs: TabLayout): RecyclerView.Adapter<PlaceBySearchAdapter.ViewHolder>(){
    var flag : Boolean = false

    private val exampleListFull: ArrayList<PlacesModel> = placesList

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var placeImage = itemView.findViewById(R.id.place_image) as ImageView
        var placeTitle = itemView.findViewById(R.id.place_title) as TextView
        var placeDescription = itemView.findViewById(R.id.place_description) as  TextView

        var write = itemView.findViewById(R.id.write) as ImageButton
    }

    class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view){
        init {
            view.setOnClickListener{
                println("Funciona")
            }
        }
    }
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

        val context = holder.itemView.context
        holder.itemView.setOnClickListener(){

        }
    }

    fun getFilter(): Filter {
        return exampleFilter
    }


    private val exampleFilter = object : Filter() {
        override fun performFiltering(constraint: CharSequence?): Filter.FilterResults {
            var filteredList : ArrayList<PlacesModel> = ArrayList()

            val results = Filter.FilterResults()


            if (constraint == null || constraint.isEmpty()) {
                Log.i("debug", "Nada" )
                filteredList.addAll(exampleListFull)
                flag = false

            } else {
                val filterPattern = constraint.toString().toLowerCase().trim { it <= ' ' }

                for (item in exampleListFull) {
                    if (item.title.toLowerCase().contains(filterPattern)) {
                        filteredList.add(item)
                    }
                    flag = true
                }
                Log.i("debug", "Algo" )

            }
//            filteredList.addAll(exampleListFull)

            results.values = filteredList

            return results
        }


        override fun publishResults(constraint: CharSequence, results: Filter.FilterResults) {
            placesList.clear()
            placesList.addAll(results.values as Collection<PlacesModel>)
            notifyDataSetChanged()
        }
    }
}