package com.testing.what2dotoday.ui.places

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.*
import android.os.Handler
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.testing.what2dotoday.R
import com.testing.what2dotoday.SignInActivity
import kotlinx.android.synthetic.main.fragment_prices.*
import android.content.Intent
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationResult
import com.testing.what2dotoday.ui.profile.ProfileFragment
import com.testing.what2dotoday.ui.test.TestAdapter
import com.testing.what2dotoday.ui.test.TestModel
import kotlinx.android.synthetic.main.fragment_home.*
import org.w3c.dom.Text
import kotlin.random.Random


class PlaceByPriceAdapter(val placesList: ArrayList<PlacesModel>): RecyclerView.Adapter<PlaceByPriceAdapter.ViewHolder>(){

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
        fun onLocationResult(p0: LocationResult?) {
            var location = p0!!.locations.get(p0!!.locations.size - 1)
            var latitude = location.latitude
            var longitude = location.longitude
            println("WHATTHEFYCH")
            println(latitude)
        }
        if(row.price === "Medium"){
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
    }

}
