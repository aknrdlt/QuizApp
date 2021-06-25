package com.aknrdlt.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var btnLogin : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLogin = findViewById(R.id.b_login)

        btnLogin.setOnClickListener(){
            val intent = Intent(this, QuestionActivity::class.java)
            startActivity(intent);
        }
    }
}