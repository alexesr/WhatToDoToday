package com.testing.what2dotoday.ui.places

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.os.Handler
import androidx.recyclerview.widget.RecyclerView
import com.testing.what2dotoday.R
import com.testing.what2dotoday.SignInActivity
import android.content.Intent
import android.graphics.drawable.LayerDrawable
import android.os.Debug
import android.util.Log
import androidx.cardview.widget.CardView
import com.google.android.gms.location.LocationResult
import com.testing.what2dotoday.MainActivity

class PlaceByPriceAdapter(val placesList: ArrayList<PlacesModel>): RecyclerView.Adapter<PlaceByPriceAdapter.ViewHolder>(){

    private lateinit var myhandler: Handler
    private lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.place_row ,parent,false)
        context = parent.context
        myhandler = Handler()
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return placesList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val row: PlacesModel = placesList[position]

        if(row.price === "Medium"){
            holder.placeImage.setImageResource(row.image)
            holder.placeTitle.text = row.title
            holder.placeDescription.text = row.description
            holder.placeLoc.text = "Near"
            holder.placePrice.text = row.price
            holder.write.setOnClickListener{

                var dialog = PlacesDialogFragment()
                dialog.show(holder.activity!!.supportFragmentManager, "ViewDialog")

            }
        }else{
            holder.card.removeView(holder.lay)
        }
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var placeImage = itemView.findViewById(R.id.place_image) as ImageView
        var placeTitle = itemView.findViewById(R.id.place_title) as TextView
        var placeDescription = itemView.findViewById(R.id.place_description) as  TextView
        var placeLoc = itemView.findViewById(R.id.location) as TextView
        var placePrice =  itemView.findViewById(R.id.price) as TextView

        var write = itemView.findViewById(R.id.write) as ImageButton
        var card = itemView.findViewById(R.id.cardL) as CardView
        var lay = itemView.findViewById(R.id.lay) as RelativeLayout
        var activity = itemView.context as? MainActivity
    }

}
