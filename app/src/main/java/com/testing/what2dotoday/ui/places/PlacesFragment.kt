package com.testing.what2dotoday.ui.places

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_places.*
import com.google.android.material.tabs.TabLayout
import com.testing.what2dotoday.R

class PlacesFragment : Fragment() {

    private lateinit var placesList: ArrayList<PlacesModel>

    private lateinit var tabs: TabLayout
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? = inflater.inflate(R.layout.fragment_places,container,false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tabs = tabsid
        tabs.addTab(tabs.newTab().setText("Location"))
        tabs.addTab(tabs.newTab().setText("Price"))
        tabs.addTab(tabs.newTab().setText("All"))


        placesList = ArrayList<PlacesModel>()
        placesList.add(PlacesModel(R.drawable.beach,"Beach","Descripcion de la playa", "Near", "Cheap"))
        placesList.add(PlacesModel(R.drawable.forest,"Forest","Descripcion de Forest", "Far", "Medium"))
        placesList.add(PlacesModel(R.drawable.mountain,"Beach","Descripción de la Montaña", "Near", "Expensive"))
        placesList.add(PlacesModel(R.drawable.desert, "Desert", "Descripción del Desierto","Far", "Cheap"))
        places_recyclyerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = PlaceByCategoryAdapter(placesList)
        }
    }
    companion object {
        fun newInstance(): PlacesFragment = PlacesFragment()
    }
}