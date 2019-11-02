package com.testing.what2dotoday.ui.places

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.SearchView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.testing.what2dotoday.R
import kotlinx.android.synthetic.main.fragment_places.*
import org.w3c.dom.Text

class PlacesFragment : Fragment() {

    private lateinit var places_adapter: PlaceBySearchAdapter
    private lateinit var placesList: ArrayList<PlacesModel>

    override fun onCreateView(
        inflater: LayoutInflater,

        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        setHasOptionsMenu(true)

        return inflater.inflate(R.layout.fragment_places,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        placesList = ArrayList<PlacesModel>()
        placesList.add(PlacesModel(R.drawable.beach,"Playa Taki Taki","Descripcion de la playa"))
        placesList.add(PlacesModel(R.drawable.beach,"Forest Azul","Descripcion de Forest"))
        placesList.add(PlacesModel(R.drawable.beach,"Abolengo","Descripcion de Abolengo, un antro"))
        places_adapter = PlaceBySearchAdapter(placesList)
        places_recyclyerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = places_adapter
        }

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater){
        // Inflate the menu; this adds items to the action bar if it is present.
        inflater.inflate(R.menu.menu_search, menu)
        val searchItem = menu.findItem(R.id.app_bar_search)
        val searchView = searchItem.actionView as SearchView
        searchView.queryHint = "Ingresa un lugar"
        searchView.setOnQueryTextListener(object :  SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean {
                places_adapter.getFilter().filter(newText)
                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                places_adapter.getFilter().filter(query)
                return false
            }

        })

    }


    companion object {
        fun newInstance(): PlacesFragment = PlacesFragment()
    }
}