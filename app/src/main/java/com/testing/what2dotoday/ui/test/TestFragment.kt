package com.testing.what2dotoday.ui.test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.testing.what2dotoday.R
import kotlinx.android.synthetic.main.fragment_test.*

class TestFragment : Fragment() {

    private lateinit var answerList: ArrayList<TestModel>
    lateinit  var recyclerView: RecyclerView
    lateinit var question: TextView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? = inflater.inflate(R.layout.fragment_test,container,false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //This are only used for the Adpater
        question = questionText
        recyclerView = activity_test_recyclerView

        question.text= "Elige un paisaje"
        this.answerList = ArrayList<TestModel>()
        this.answerList.add(TestModel(R.drawable.desert,R.drawable.mountain,R.drawable.forest,R.drawable.beach))
        activity_test_recyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = TestAdapter(answerList, this@TestFragment)
        }
    }
    /*
    companion object{
        fun newInstance(): TestFragment = TestFragment()
    }*/
}