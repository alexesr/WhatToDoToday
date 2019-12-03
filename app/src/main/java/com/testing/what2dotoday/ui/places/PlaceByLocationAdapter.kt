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
import androidx.cardview.widget.CardView
import com.google.android.gms.location.LocationCallback
import com.testing.what2dotoday.MainActivity


class PlaceByLocationAdapter(val placesList: ArrayList<PlacesModel>): RecyclerView.Adapter<PlaceByLocationAdapter.ViewHolder>(){

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

        if(row.lat > 10.0 && row.long < 11.5){
            holder.placeImage.setImageResource(row.image)
            holder.placeTitle.text = row.title
            holder.placeDescription.text = row.description
            holder.placeLoc.text = "Near"
            holder.placePrice.text = row.price
            holder.write.setOnClickListener{
                val dialog = PlacesDialogFragment()
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
