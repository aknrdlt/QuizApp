package com.aknrdlt.quizapp.question

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.aknrdlt.quizapp.R
import com.aknrdlt.quizapp.ResultActivity
import com.aknrdlt.quizapp.login.MainActivity


class QuestionActivity : AppCompatActivity() {

    private lateinit var viewPager : ViewPager
    private lateinit var adapter : MyAdapter
    private lateinit var btnNext: Button
    private lateinit var quiteQuiz: TextView
    private val TAG = QuestionActivity::class.java.simpleName
    private lateinit var sharedPreferences : SharedPreferences

    val map : MutableMap<Int, String> = mutableMapOf()
    var page = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
        sharedPreferences = getSharedPreferences("RADIO_BUTTON", Context.MODE_PRIVATE);


        setupViewPager();

        btnNext = findViewById(R.id.b_next)

        btnNext.setOnClickListener(){
            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1, true);

            val radio_group: RadioGroup? = findViewById(R.id.radioGroup)
            val radioId : Int? = radio_group?.getCheckedRadioButtonId()
            val lastButtonState : Boolean = sharedPreferences.getBoolean("BUTTON_STATE", false)
            // restore previous state
            if (radioId != null){
                val radioButton: RadioButton? = findViewById(radioId!!)
                radioButton?.setChecked(lastButtonState)

                val editor: SharedPreferences.Editor = sharedPreferences.edit()
                val isChecked: Boolean = radioButton?.isChecked() == true
                // use this to add the new state
                // use this to add the new state
                editor.putBoolean("BUTTON_STATE", isChecked)
                // save
                // save
                editor.apply()
                map.put(page, radioButton?.text.toString())

                Log.d(TAG, map.toString() + "fffffffffffffffffffffffffffffffffffff")
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
                        val intent1 = Intent(this@QuestionActivity, ResultActivity::class.java)
                        startActivity(intent1);
                    }
                }
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })
    }
}
