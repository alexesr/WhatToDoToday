package com.testing.what2dotoday.ui.home

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.android.gms.location.*
import com.google.firebase.auth.FirebaseAuth
import com.testing.what2dotoday.MainActivity
import com.testing.what2dotoday.R
import com.testing.what2dotoday.SignInActivity
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*


class HomeFragment : Fragment() {

    lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    lateinit var locationRequest: LocationRequest
    lateinit var locationCallback: LocationCallback

    private lateinit var homeViewModel: HomeViewModel

    val code  = 1000

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode){
            code->{
                if(grantResults.size>0){
                    if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                        Toast.makeText(getActivity()?.getApplicationContext(), "Listo", Toast.LENGTH_LONG).show()
                    }else{
                        Toast.makeText(getActivity()?.getApplicationContext(),"Not granted", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    override fun onCreateView(

        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
<<<<<<< HEAD

=======
        //setupUI()
>>>>>>> be443126bd5dc14843cf698fdb9b0f75de7a6a8a
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(this, Observer {
            textView.text = it
        })

        //Check permission for geolation
        if(ActivityCompat.shouldShowRequestPermissionRationale(
                getContext() as Activity,
                Manifest.permission.ACCESS_COARSE_LOCATION
            )){
            ActivityCompat.requestPermissions(getContext() as Activity, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),code)
        }else {
            buildLocationRequest()
            buildLocationCallback()
            fusedLocationProviderClient =
                LocationServices.getFusedLocationProviderClient(getContext() as Activity)


            root.btn_start_updates.setOnClickListener(View.OnClickListener {
                if (ActivityCompat.checkSelfPermission(getContext() as Activity,
                        Manifest.permission.ACCESS_FINE_LOCATION
                    ) != PackageManager.PERMISSION_GRANTED &&
                    ActivityCompat.checkSelfPermission(getContext() as Activity,
                        Manifest.permission.ACCESS_COARSE_LOCATION
                    ) != PackageManager.PERMISSION_GRANTED )
                {
                    ActivityCompat.requestPermissions(getContext() as Activity, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), code)
                    return@OnClickListener
                }
                fusedLocationProviderClient.requestLocationUpdates(locationRequest, locationCallback, Looper.myLooper())
                root.btn_start_updates.isEnabled = !btn_start_updates.isEnabled
            })
        }

        return root
    }
    private fun buildLocationRequest(){
        locationRequest = LocationRequest()
        locationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        locationRequest.interval = 5000
        locationRequest.fastestInterval = 3000
        locationRequest.smallestDisplacement = 10f

    }
    private fun buildLocationCallback(){
        locationCallback = object : LocationCallback(){
            override fun onLocationResult(p0: LocationResult?) {
                var location = p0!!.locations.get(p0!!.locations.size-1)
                txt_location.text = location.latitude.toString()+"/"+location.longitude.toString()
            }
        }
    }


}