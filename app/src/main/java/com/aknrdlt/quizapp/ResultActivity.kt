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
    lateinit var tvName : TextView
    lateinit var tvScore : TextView
    lateinit var bLogout : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        preferences = getSharedPreferences("SHARED_PREF", MODE_PRIVATE)

        val name = preferences.getString("NAME", "")
        val score = preferences.getString("SCORE", "")

        tvName = findViewById(R.id.tv_your_score)
        bLogout = findViewById(R.id.b_logout)
        tvScore = findViewById(R.id.tv_score)

        tvName.text = name + ", your score"
        tvScore.text = score

        bLogout.setOnClickListener(){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent);
        }
    }
}