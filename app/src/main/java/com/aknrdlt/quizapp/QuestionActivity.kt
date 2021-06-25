package com.aknrdlt.quizapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener


class QuestionActivity : AppCompatActivity() {

    private lateinit var viewPager : ViewPager
    private lateinit var adapter : MyAdapter
    private lateinit var btnNext: Button
    private lateinit var quiteQuiz: TextView

    var page = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        setupViewPager();

        btnNext = findViewById(R.id.b_next)

        btnNext.setOnClickListener(){
            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1, true);
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
                    btnNext.text = "Next"
                    btnNext.visibility = View.VISIBLE
                }else{
                    btnNext.text = "Finish"
                }
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })
    }
}