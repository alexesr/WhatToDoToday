package com.testing.what2dotoday.ui.Test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.testing.what2dotoday.R

class GalleryFragment : Fragment() {

    private lateinit var testViewModel: TestViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        testViewModel =
            ViewModelProviders.of(this).get(TestViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_test, container, false)
        val textView: TextView = root.findViewById(R.id.text_gallery)
        testViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}