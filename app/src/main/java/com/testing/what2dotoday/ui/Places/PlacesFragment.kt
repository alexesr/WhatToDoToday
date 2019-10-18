package com.testing.what2dotoday.ui.Places

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.testing.what2dotoday.R


class PlacesFragment : Fragment() {

    //private lateinit var placesViewModel: PlacesViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         //placesViewModel =
          //  ViewModelProviders.of(this).get(PlacesViewModel::class.java)


        val root = inflater.inflate(R.layout.place_row, container, false)
        /*
        val titleImage:TextView = root.findViewById(R.id.place_title)
        val imageView: ImageView = root.findViewById(R.id.place_image)

        placesViewModel.text.observe(this, Observer {
            //textView.text = it

        }) */
        val arr = ArrayList<PlacesViewModel>()
        arr.add(ViewModelProviders.of(this).get(PlacesViewModel::class.java))
        arr.add(ViewModelProviders.of(this).get(PlacesViewModel::class.java))
        arr.add(ViewModelProviders.of(this).get(PlacesViewModel::class.java))
        return root
    }
}