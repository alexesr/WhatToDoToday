package com.testing.what2dotoday.ui.places

import android.os.Bundle
import android.os.LocaleList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_places.*
import com.google.android.material.tabs.TabLayout
import com.testing.what2dotoday.R
import com.testing.what2dotoday.ui.home.HomeFragment
import com.testing.what2dotoday.ui.home.HomeViewModel

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

        placesList = ArrayList<PlacesModel>()
        placesList.add(PlacesModel(R.drawable.beach,"Beach","Descripcion de la playa", 3.13, 10.10,"Cheap"))
        placesList.add(PlacesModel(R.drawable.forest,"Forest","Descripcion de Forest", 10.57, 30.3,"Medium"))
        placesList.add(PlacesModel(R.drawable.mountain,"Beach","Descripción de la Montaña", 60.59, 10.10,"Expensive"))
        placesList.add(PlacesModel(R.drawable.desert, "Desert", "Descripción del Desierto",20.11, 10.10,"Cheap"))
        places_recyclyerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = PlaceByCategoryAdapter(placesList)
        }
    }
    companion object {
        fun newInstance(): PlacesFragment = PlacesFragment()
    }
}