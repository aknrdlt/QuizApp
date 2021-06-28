package com.aknrdlt.quizapp.login

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.aknrdlt.quizapp.R
import com.aknrdlt.quizapp.question.QuestionActivity

class MainActivity : AppCompatActivity() {
    private lateinit var btnLogin : Button
    private lateinit var sharedPreferences : SharedPreferences
    var isRemembered = false
    private lateinit var nameText : EditText
    private lateinit var checkBox : CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLogin = findViewById(R.id.b_login)
        nameText = findViewById(R.id.et_login)
        checkBox = findViewById(R.id.cb_login)

        sharedPreferences = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)
        isRemembered = sharedPreferences.getBoolean("CHECK", false)

        btnLogin.setOnClickListener(){
            if(nameText.text.toString() != ""){
                val name : String = nameText.text.toString()
                val checked : Boolean = checkBox.isChecked

                val editor : SharedPreferences.Editor = sharedPreferences.edit()

                if(isRemembered){
                    editor.putString("NAME", name)
                    editor.putBoolean("CHECKBOX", checked)
                    editor.apply()

                    Toast.makeText(this, "Info saved!", Toast.LENGTH_SHORT).show()
                }

                val intent = Intent(this, QuestionActivity::class.java)
                startActivity(intent);
                finish()
            }
        }
    }
}