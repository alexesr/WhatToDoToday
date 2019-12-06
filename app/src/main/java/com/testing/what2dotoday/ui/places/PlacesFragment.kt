package com.testing.what2dotoday.ui.places

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import kotlinx.android.synthetic.main.fragment_places.*
import com.google.android.material.tabs.TabLayout
import com.testing.what2dotoday.R
import com.testing.what2dotoday.ui.home.HomeViewModel
import com.android.volley.toolbox.Volley
import com.google.gson.Gson

class PlacesFragment : Fragment() {

    private lateinit var placesList: ArrayList<PlacesModel>
    private lateinit var userLocation: ArrayList<HomeViewModel>

    private lateinit var tabs: TabLayout
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? = inflater.inflate(R.layout.fragment_places,container,false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val requestQueue = Volley.newRequestQueue(this.context)
        val url = "https://w2dt.herokuapp.com/lugares"

        placesList = ArrayList()

        val stringRequest = StringRequest(Request.Method.GET, url,
            Response.Listener<String> { response ->
                // Do something with the response
                //TODO: Get the elements from the response
                //Add each element to the array
                val gson = Gson()
                val json =  response
                val responseObject = gson.fromJson(json,PlacesResponse::class.java)
                //Log.e("object:",responseObject.message)
                val len = responseObject.lugares?.size
                for(i in 0 until len!!){
                    var place = responseObject.lugares!!.get(i)
                    placesList.add(PlacesModel(R.drawable.beach,place.nombre,getDescription(place.categoria),place.latitud.toDouble(),place.longitud.toDouble(),getPrice(place.precio)))
                }
                places_recyclyerView.apply {
                    layoutManager = LinearLayoutManager(activity)
                    adapter = PlaceByCategoryAdapter(placesList)
                }
            },
            Response.ErrorListener { error ->
                // Handle error
                //textView.text = "ERROR: %s".format(error.toString())
            })
        requestQueue.add(stringRequest)
    }
    companion object {
        fun newInstance(): PlacesFragment = PlacesFragment()
    }

    fun getDescription(s:String):String{
        var des = ""
        if (s[s.length-2] == '1') {
            des = "Eventos Familiares"
        }else if(s[s.length-2] == '3'){
            des = "Actividades Extremas"
        }
        return des
    }
    fun getPrice(s:String):String{
        var price =""
        if(s[s.length-2] == '1') {
            price = "Expensive"
        }else if(s[s.length-2] == '2'){
            price = "Cheap"
        }else if(s[s.length-2] == '3'){
            price = "Medium"
        }
        return price
    }

}

