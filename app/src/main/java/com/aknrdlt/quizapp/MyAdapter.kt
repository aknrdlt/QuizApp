package com.aknrdlt.quizapp

import android.content.Context
import android.content.Context.LAYOUT_INFLATER_SERVICE
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter


class MyAdapter(context: Context) : PagerAdapter() {
    var context: Context
    var inflater: LayoutInflater? = null
    // list judul
    var list_judul = intArrayOf(
        R.string.question_1,
        R.string.question_2,
        R.string.question_3,
        R.string.question_4,
        R.string.question_5,
        R.string.question_6,
        R.string.question_7,
        R.string.question_8,
        R.string.question_9
    )

    override fun getCount(): Int {
        return list_judul.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        inflater = context.getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater?
        val view: View = inflater?.inflate(R.layout.activity_single, container, false)!!
        val question: TextView = view.findViewById(R.id.tv_question)
        question.setText(list_judul[position])
        val question_number: TextView = view.findViewById(R.id.tv_question_number)
        question_number.setText("Question ${position + 1}")
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