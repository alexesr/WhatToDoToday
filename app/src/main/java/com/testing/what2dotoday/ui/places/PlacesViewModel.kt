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
    private val _loc = MutableLiveData<String>().apply {
        value = "Near"
    }
    private val _price = MutableLiveData<String>().apply {
        value = "Default"
    }
    val placeImage:LiveData<Int> = _placeImage
    val placeTitle: LiveData<String> = _placeTitle
    val placeDescription: LiveData<String> = _placeDescription
    val loc: LiveData<String> = _loc
    val price: LiveData<String> = _price
}
