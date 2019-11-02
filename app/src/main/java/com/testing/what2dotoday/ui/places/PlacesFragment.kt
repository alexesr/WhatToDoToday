package com.testing.what2dotoday.ui.places

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.testing.what2dotoday.R
import kotlinx.android.synthetic.main.fragment_places.*
import org.w3c.dom.Text


class PlacesFragment : Fragment() {

    private lateinit var placesList: ArrayList<PlacesModel>
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? = inflater.inflate(R.layout.fragment_places,container,false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        placesList = ArrayList<PlacesModel>()
        placesList.add(PlacesModel(R.drawable.beach, "Playa Taki Taki", "Descripcion de la playa"))
        placesList.add(PlacesModel(R.drawable.beach, "Forest Azul", "Descripcion de Forest"))
        placesList.add(
            PlacesModel(
                R.drawable.beach,
                "Abolengo",
                "Descripcion de Abolengo, un antro"
            )
        )
        places_recyclyerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = PlaceByCategoryAdapter(placesList)
        }
    }
    companion object {
        fun newInstance(): PlacesFragment = PlacesFragment()
    }
}