package com.testing.what2dotoday.ui.places

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.os.Handler
import androidx.recyclerview.widget.RecyclerView
import com.testing.what2dotoday.R
import com.testing.what2dotoday.SignInActivity
import android.content.Intent
import com.google.android.gms.location.LocationCallback

class PlaceByCategoryAdapter(val placesList: ArrayList<PlacesModel>): RecyclerView.Adapter<PlaceByCategoryAdapter.ViewHolder>(){

    private lateinit var myhandler: Handler
    private  val splashTime = 500L
    lateinit var locationCallback: LocationCallback

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.place_row ,parent,false)
        myhandler = Handler()
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
        holder.placeLoc.text = "Near"
        holder.placePrice.text = row.price
        holder.write.setOnClickListener{

            val context = holder.itemView.context
            val intent = Intent(context, SignInActivity::class.java)
            context.startActivity(intent)
        }
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var placeImage = itemView.findViewById(R.id.place_image) as ImageView
        var placeTitle = itemView.findViewById(R.id.place_title) as TextView
        var placeDescription = itemView.findViewById(R.id.place_description) as  TextView
        var placeLoc = itemView.findViewById(R.id.location) as TextView
        var placePrice =  itemView.findViewById(R.id.price) as TextView

        var write = itemView.findViewById(R.id.write) as ImageButton
    }

}
