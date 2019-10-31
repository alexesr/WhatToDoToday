package com.testing.what2dotoday.ui.profile

import android.media.Image
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.firebase.auth.FirebaseAuth
import com.squareup.picasso.Picasso
import com.testing.what2dotoday.R
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {

    private lateinit var profileViewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val user = FirebaseAuth.getInstance().currentUser
        profileViewModel =
            ViewModelProviders.of(this).get(ProfileViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_profile, container, false)
        val textUser: TextView = root.findViewById(R.id.profile_name)
        val textEmail: TextView = root.findViewById(R.id.profile_email)
        val image: ImageView = root.findViewById(R.id.profile_image)


        profileViewModel.text.observe(this, Observer {
                if(user!=null){
                    textUser.text = user.displayName
                    textEmail.text = user.email
                    val photoUrl = user.photoUrl
                    //Log.i("Foto", photoUrl.toString())
                    Picasso.get().load(photoUrl).into(image);

                }else{
                    textUser.text = null
                    textEmail.text = null
                }
            })
        return root
    }
}