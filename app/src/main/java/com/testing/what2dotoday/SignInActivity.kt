package com.testing.what2dotoday

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.android.synthetic.main.activity_sign_in.*

import kotlinx.android.synthetic.main.fragment_profile.profile_name

class SignInActivity : AppCompatActivity() {

    val RC_SIGN_IN: Int = 1
    lateinit var mGoogleSignInClient: GoogleSignInClient
    lateinit var mGoogleSignInOptions: GoogleSignInOptions
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        //Button listeners
        setupUI()
        //Configure google sign in
        configureGoogleSignIn()
        //Initialize firebase auth after google sign in
        firebaseAuth = FirebaseAuth.getInstance()



    }
    private fun setupUI() {
        google_button.setOnClickListener {
            signIn()
        }
    }
    private fun configureGoogleSignIn() {
        mGoogleSignInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        mGoogleSignInClient = GoogleSignIn.getClient(this, mGoogleSignInOptions)
    }

    private fun signIn() {
        val signInIntent: Intent = mGoogleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    override fun onStart() {
        super.onStart()
        val user = FirebaseAuth.getInstance().currentUser
        val mainActivityIntent = Intent(applicationContext, MainActivity::class.java)
        if (user != null) {
            startActivity(mainActivityIntent)
            finish()
        }
    }



    private fun firebaseAuthWithGoogle(acct: GoogleSignInAccount) {
        val mainActivityIntent = Intent(applicationContext, MainActivity::class.java)
        val credential = GoogleAuthProvider.getCredential(acct.idToken, null)
        firebaseAuth.signInWithCredential(credential).addOnCompleteListener {

            if (it.isSuccessful) {
                startActivity(mainActivityIntent)
            } else {
                Toast.makeText(this, "it.Sucessful returned false", Toast.LENGTH_LONG).show()
            }
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        //borrar:
        val mainActivityIntent = Intent(applicationContext, MainActivity::class.java)
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_SIGN_IN) {
            val task: Task<GoogleSignInAccount> = GoogleSignIn.getSignedInAccountFromIntent(data)
            //borrar:
            startActivity(mainActivityIntent)
            try {
                //Gets google account
                val account = task.getResult(ApiException::class.java)
                if (account != null) {
                    firebaseAuthWithGoogle(account)
                }
            } catch (e: ApiException) {
                Toast.makeText(this, "Account returned null", Toast.LENGTH_LONG).show()
            }
        }
    }


}
