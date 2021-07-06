package com.aknrdlt.quizapp.result

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aknrdlt.quizapp.R
import com.aknrdlt.quizapp.data.User
import com.aknrdlt.quizapp.Users
import com.aknrdlt.quizapp.login.MainActivity
import com.aknrdlt.quizapp.result.adapter.UserListAdapter


class ResultActivity : AppCompatActivity() {
    lateinit var preferences : SharedPreferences
    lateinit var recyclerView: RecyclerView
    lateinit var tvName : TextView
    lateinit var tvScore : TextView
    lateinit var bLogout : Button
    lateinit var userListAdapter: UserListAdapter


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

        initRecyclerView()

        loadUsers()

        bLogout.setOnClickListener(){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent);
        }
    }

    private fun loadUsers() {
        val users: MutableList<User> = Users.usersList()
        users.add(User(4, preferences.getString("NAME", "").toString(), 4))
        userListAdapter?.setItems(users)
    }

    private fun initRecyclerView() {
        recyclerView = findViewById(R.id.recycler_view)
        userListAdapter = UserListAdapter()
        recyclerView.setAdapter(userListAdapter)
        recyclerView.setLayoutManager(LinearLayoutManager(this));
    }
}