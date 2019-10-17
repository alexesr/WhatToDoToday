package com.testing.waht2dotoday

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashScreenActivity : AppCompatActivity() {
    private val splashtime = 2000L
    private lateinit var myhandler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)
        myhandler = Handler()
        myhandler.postDelayed({
            gotToSignIn()
        },splashtime)

    }
    private fun gotToSignIn(){
        val signInActivityIntent = Intent(applicationContext, SignInActivity::class.java)
        startActivity(signInActivityIntent)
        finish()
    }
}
