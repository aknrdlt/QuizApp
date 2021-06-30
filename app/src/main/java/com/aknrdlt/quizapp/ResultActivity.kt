package com.aknrdlt.quizapp

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.aknrdlt.quizapp.login.MainActivity

class ResultActivity : AppCompatActivity() {
    lateinit var preferences : SharedPreferences
    lateinit var tv_name : TextView
    lateinit var b_logout : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        preferences = getSharedPreferences("SHARED_PREF", MODE_PRIVATE)

        val name = preferences.getString("NAME", "")

        tv_name = findViewById(R.id.tv_your_score)
        b_logout = findViewById(R.id.b_logout)

        tv_name.text = name + ", your score"

        b_logout.setOnClickListener(){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent);
        }
    }
}