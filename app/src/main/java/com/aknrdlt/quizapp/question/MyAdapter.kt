package com.aknrdlt.quizapp.question

import android.content.Context
import android.content.Context.LAYOUT_INFLATER_SERVICE
import android.content.SharedPreferences
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.aknrdlt.quizapp.R
import com.aknrdlt.quizapp.data.Question
import com.aknrdlt.quizapp.data.Questions


class MyAdapter(context: Context) : PagerAdapter() {
    var context: Context
    var inflater: LayoutInflater? = null

    override fun getCount(): Int {
        // yeah proooblem))
        return Questions.questionsList().size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        inflater = context.getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater?
        val view: View = inflater?.inflate(R.layout.activity_single, container, false)!!

        val question_number: TextView = view.findViewById(R.id.tv_question_number)
        question_number.setText("Question ${position + 1}")

        val question: TextView = view.findViewById(R.id.tv_question)
        val questionList = Questions.questionsList()
        question.setText(questionList[position].question)

        val optionA: TextView = view.findViewById(R.id.optionA)
        val optionB: TextView = view.findViewById(R.id.optionB)
        val optionC: TextView = view.findViewById(R.id.optionC)
        val optionD: TextView = view.findViewById(R.id.optionD)
        optionA.setText(questionList[position].optionA)
        optionB.setText(questionList[position].optionB)
        optionC.setText(questionList[position].optionC)
        optionD.setText(questionList[position].optionD)

        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as LinearLayout)
    }

    init {
        this.context = context
    }
}