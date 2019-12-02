package com.testing.what2dotoday.ui.places

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import android.view.WindowManager
import android.R
import android.content.Intent
import android.net.Uri
import android.os.Handler
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.annotation.Nullable
import androidx.core.content.ContextCompat.startActivity


class PlacesDialogFragment : DialogFragment() {

    private lateinit var myhandler: Handler

    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceByCategoryAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(com.testing.what2dotoday.R.layout.place_row, parent, false)
        myhandler = Handler()

        return PlaceByCategoryAdapter.ViewHolder(v)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            // Get the layout inflater
            val inflater = requireActivity().layoutInflater;

            // Inflate and set the layout for the dialog
            // Pass null as the parent view because its going in the dialog layout
            builder.setView(inflater.inflate(com.testing.what2dotoday.R.layout.write_message, null))
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

    fun onBindViewHolder(view: View) {

        val message = view.findViewById(com.testing.what2dotoday.R.id.messageEt) as TextView
        // Fetch arguments from bundle and set title
        val subject = view.findViewById(com.testing.what2dotoday.R.id.subjectEt) as TextView
        val sendBtn = view.findViewById(com.testing.what2dotoday.R.id.sendEmailBtn) as Button

        sendBtn.setOnClickListener {
            val recipient = "maritza_rh97@hotmail.com"
            val subject = subject.text.toString().trim()
            val message = message.text.toString().trim()

            sendEmail(recipient, subject, message)
        }
    }

    private fun sendEmail(recipient: String, subject: String, message: String) {
        /*ACTION_SEND action to launch an email client installed on your Android device.*/
        val mIntent = Intent(Intent.ACTION_SEND)
        /*To send an email you need to specify mailto: as URI using setData() method
        and data type will be to text/plain using setType() method*/
        mIntent.data = Uri.parse("mailto:")
        mIntent.type = "text/plain"
        // put recipient email in intent
        /* recipient is put as array because you may wanna send email to multiple emails
           so enter comma(,) separated emails, it will be stored in array*/
        mIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(recipient))
        //put the Subject in the intent
        mIntent.putExtra(Intent.EXTRA_SUBJECT, subject)
        //put the message in the intent
        mIntent.putExtra(Intent.EXTRA_TEXT, message)


        //Toast.makeText(this, "Account returned null", Toast.LENGTH_LONG).show()
    }
}