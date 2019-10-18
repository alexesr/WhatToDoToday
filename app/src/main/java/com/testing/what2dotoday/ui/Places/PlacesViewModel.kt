package com.testing.what2dotoday.ui.Places

import android.widget.ImageView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PlacesViewModel : ViewModel() {

    private val _placeImage = MutableLiveData<ImageView>().apply {}

    private val _placeTitle = MutableLiveData<String>().apply {
        value = "Default text"
    }
    private val _placeDescription = MutableLiveData<String>().apply {
        value = "Default desciption"
    }
    val placeImage: LiveData<ImageView> = _placeImage
    val placeTitle: LiveData<String> = _placeTitle
    val placeDescription: LiveData<String> = _placeDescription
}