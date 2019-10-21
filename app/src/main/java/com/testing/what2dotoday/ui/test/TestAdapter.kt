package com.testing.what2dotoday.ui.test


import android.annotation.SuppressLint
import android.os.Vibrator
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import android.os.Handler
import androidx.recyclerview.widget.LinearLayoutManager
import com.testing.what2dotoday.R
import kotlinx.android.synthetic.main.fragment_test.*
import kotlinx.android.synthetic.main.fragment_test.view.*
import kotlinx.android.synthetic.main.fragment_test.view.questionText
import kotlin.random.Random


class TestAdapter(val answerList: ArrayList<TestModel>, val testFragment: TestFragment): RecyclerView.Adapter<TestAdapter.ViewHolder>(){

    private  val splashTime = 500L
    private lateinit var myhandler: Handler
    private lateinit var vibrator: Vibrator

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.test_answer_template, parent, false)
        myhandler = Handler()
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return  answerList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val row: TestModel = answerList[position]
        holder.answerTL.setImageResource(row.topLeft)
        holder.answerTR.setImageResource(row.topRight)
        holder.answerBL.setImageResource(row.bottomLeft)
        holder.answerBR.setImageResource(row.bottomRight)

        holder.answerTL.setOnClickListener{
            clicked(1)
        }

        holder.answerTR.setOnClickListener{
            clicked(2)
        }
        holder.answerBL.setOnClickListener{
            clicked(3)
        }
        holder.answerBR.setOnClickListener{
            clicked(4)
        }

    }
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var answerTL = itemView.findViewById(R.id.answerTL) as ImageView
        var answerTR = itemView.findViewById(R.id.answerTR) as ImageView
        var answerBL = itemView.findViewById(R.id.answerBL) as ImageView
        var answerBR = itemView.findViewById(R.id.answerBR) as ImageView
    }
    @SuppressLint("WrongConstant")
    fun refresh(){

        testFragment.question.text = "Nueva Pregunta"
        testFragment.recyclerView.layoutManager = LinearLayoutManager(testFragment.context)

        val rows = ArrayList<TestModel>()
        val images = ArrayList<Int>()
        images.add(R.drawable.beach)
        images.add(R.drawable.forest)
        images.add(R.drawable.desert)
        images.add(R.drawable.mountain)

        val img_1 = images.get(Random.nextInt(0,4))
        val img_2 = images.get(Random.nextInt(0,4))
        val img_3 = images.get(Random.nextInt(0,4))
        val img_4 = images.get(Random.nextInt(0,4))
        rows.add(TestModel(img_1, img_2,img_3, img_4))
        testFragment.recyclerView.adapter = TestAdapter(rows,testFragment)
        testFragment.recyclerView.adapter = testFragment.recyclerView.adapter
    }
    fun clicked(buttonIndex: Int){
        val text = "Presionaste: " + buttonIndex
        val duration = Toast.LENGTH_SHORT
        val toast = Toast.makeText(testFragment.context,text,duration)

        toast.show()

        myhandler.postDelayed({
            refresh()
        },splashTime)
    }

}
