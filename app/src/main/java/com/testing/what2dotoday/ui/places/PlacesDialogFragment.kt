package com.testing.what2dotoday.ui.places

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import android.R
import android.content.Intent
import android.content.Context
import android.os.Debug
import android.os.Handler
import android.util.Log
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.view.Gravity
import android.widget.*
import android.widget.Toast
import kotlinx.android.synthetic.main.place_row.*
import kotlinx.android.synthetic.main.write_message.view.*

class PlacesDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            // Get the layout inflater
            val inflater = requireActivity().layoutInflater;

            // Inflate and set the layout for the dialog
            // Pass null as the parent view because its going in the dialog layout
            val view:View = inflater.inflate(com.testing.what2dotoday.R.layout.write_message,null)
            view.sendEmailBtn.setOnClickListener(){
                sendInfo(view)
                Log.e("Chale:","Just in the right place")
            }
            builder.setView(view)
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
    fun sendInfo(view: View){
        val message = view.findViewById(com.testing.what2dotoday.R.id.messageEt) as TextView
        // Fetch arguments from bundle and set title
        val subject = view.findViewById(com.testing.what2dotoday.R.id.subjectEt) as TextView
        val sendBtn = view.findViewById(com.testing.what2dotoday.R.id.sendEmailBtn) as Button

        val context = this.context
        val duration = Toast.LENGTH_LONG
        try{
            val recipient = "maritza_rh97@hotmail.com"
            val subjects = subject.toString()
            val messages= message.toString()

            val intent = Intent(Intent.ACTION_SEND)
            intent.setType("plain/text")

            intent.putExtra(Intent.EXTRA_EMAIL, recipient)
            intent.putExtra(Intent.EXTRA_SUBJECT, subjects)
            intent.putExtra(Intent.EXTRA_TEXT, messages)
            startActivity(intent)
            //val toast = Toast.makeText(context, "YEIIII", duration)
            //toast.show()
        }
        catch (e: Exception){
            val toast = Toast.makeText(context, "Sending not working", duration)
            toast.show()
        }
        //val toast = Toast.makeText(context, "YEIIII2", duration)
        //toast.show()

    }

    fun onBindViewHolder(view: View) {

        val message = view.findViewById(com.testing.what2dotoday.R.id.messageEt) as TextView
        // Fetch arguments from bundle and set title
        val subject = view.findViewById(com.testing.what2dotoday.R.id.subjectEt) as TextView
        val sendBtn = view.findViewById(com.testing.what2dotoday.R.id.sendEmailBtn) as Button

        val context = this.context
        val duration = Toast.LENGTH_LONG
        try {
            sendBtn.setOnClickListener {
                try{
                    val recipient = "maritza_rh97@hotmail.com"
                    val subjects = subject.toString()
                    val messages= message.toString()

                    val intent = Intent(Intent.ACTION_SEND)
                    intent.setType("plain/text")

                    intent.putExtra(Intent.EXTRA_EMAIL, recipient)
                    intent.putExtra(Intent.EXTRA_SUBJECT, subjects)
                    intent.putExtra(Intent.EXTRA_TEXT, messages)
                    startActivity(intent)
                    val toast = Toast.makeText(context, "YEIIII", duration)
                    toast.show()
                }
                catch (e: Exception){
                    val toast = Toast.makeText(context, "Sending not working", duration)
                    toast.show()
                }
            }
            val toast = Toast.makeText(context, "YEIIII2", duration)
            toast.show()
        }
        catch (e: Exception){
            Toast.makeText(this.context,"Nooooo",Toast.LENGTH_LONG).show()
        }
    }

}