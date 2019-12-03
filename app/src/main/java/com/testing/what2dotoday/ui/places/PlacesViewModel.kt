package com.testing.what2dotoday.ui.places

import android.widget.ImageView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PlacesViewModel : ViewModel() {

    private val _placeImage = MutableLiveData<Int>().apply {
        value = 0
    }

    private val _placeTitle = MutableLiveData<String>().apply {
        value = "Default text"
    }
    private val _placeDescription = MutableLiveData<String>().apply {
        value = "Default desciption"
    }
    private val _lat = MutableLiveData<Double>().apply {
        value = 2.3
    }
    private val _long = MutableLiveData<Double>().apply {
        value = 2.9
    }
    private val _price = MutableLiveData<String>().apply {
        value = "Default"
    }
    val placeImage:LiveData<Int> = _placeImage
    val placeTitle: LiveData<String> = _placeTitle
    val placeDescription: LiveData<String> = _placeDescription
    val lat: LiveData<Double> = _lat
    val long: LiveData<Double> = _long
    val price: LiveData<String> = _price
}
