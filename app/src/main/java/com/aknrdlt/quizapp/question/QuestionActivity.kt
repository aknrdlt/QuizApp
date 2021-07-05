package com.aknrdlt.quizapp.question

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.aknrdlt.quizapp.R
import com.aknrdlt.quizapp.ResultActivity
import com.aknrdlt.quizapp.data.Questions
import com.aknrdlt.quizapp.login.MainActivity


class QuestionActivity : AppCompatActivity() {

    private lateinit var viewPager : ViewPager
    private lateinit var adapter : MyAdapter
    private lateinit var btnNext: Button
    private lateinit var quiteQuiz: TextView
    private lateinit var sharedPreferences : SharedPreferences
    var numberOfCorrectAnswers : Int = 0
    var page = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
        sharedPreferences = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)

        setupViewPager();

        btnNext = findViewById(R.id.b_next)

        btnNext.setOnClickListener(){
            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1, true)

            val radio_group: RadioGroup? = findViewById(R.id.radioGroup)
            val radioId : Int? = radio_group?.getCheckedRadioButtonId()
            if(radioId != null){
                val radioButton: RadioButton? = findViewById(radioId!!)

                val questionList = Questions.questionsList()
                if(radioButton?.text.toString().equals(questionList[page].correctAnswer)){
                    numberOfCorrectAnswers++;
                }
            }
        }

        quiteQuiz = findViewById(R.id.tv_quite)

        quiteQuiz.setOnClickListener(){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent);
        }
        pageChange();
    }

    private fun setupViewPager(){
        adapter = MyAdapter(this);
        viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);
    }

    private fun pageChange() {
        viewPager.addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }
            override fun onPageSelected(position: Int) {
                page = position
                if(position < 8){
                    btnNext.visibility = View.VISIBLE
                }else{
                    btnNext.text = "Finish"
                    btnNext.setOnClickListener(){
                        val editor : SharedPreferences.Editor = sharedPreferences.edit()
                        editor.putString("SCORE", numberOfCorrectAnswers.toString())
                        editor.apply()

                        val intent1 = Intent(this@QuestionActivity, ResultActivity::class.java)
                        startActivity(intent1)
                    }
                }
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })
    }
}
