package com.aknrdlt.quizapp.result


import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.RecyclerView
import com.aknrdlt.quizapp.FlowersListViewModelFactory
import com.aknrdlt.quizapp.R
import com.aknrdlt.quizapp.UsersListViewModel
import com.aknrdlt.quizapp.data.User
import com.aknrdlt.quizapp.login.MainActivity
import com.aknrdlt.quizapp.login.USERNAME
import com.aknrdlt.quizapp.login.SCORE

const val FLOWER_ID = "flower_id"

class FlowersListActivity : AppCompatActivity() {

    lateinit var preferences : SharedPreferences
    lateinit var tv_name : TextView
    lateinit var b_logout : Button
    private val newFlowerActivityRequestCode = 1
//
//    private val flowersListViewModel by viewModels<UsersListViewModel> {
//        FlowersListViewModelFactory(this)
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        /* Instantiates headerAdapter and flowersAdapter. Both adapters are added to concatAdapter.
        which displays the contents sequentially */
        val headerAdapter = HeaderAdapter()
        //val flowersAdapter = FlowersAdapter { flower -> adapterOnClick(flower) }
        //val concatAdapter = ConcatAdapter(headerAdapter, flowersAdapter)

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.adapter = headerAdapter


        preferences = getSharedPreferences("SHARED_PREF", MODE_PRIVATE)

        val name = preferences.getString("NAME", "")

        tv_name = findViewById(R.id.tv_your_score)
        b_logout = findViewById(R.id.b_logout)

        tv_name.text = name + ", your score"

        b_logout.setOnClickListener(){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent);
        }

//        flowersListViewModel.flowersLiveData.observe(this, {
//            it?.let {
//                flowersAdapter.submitList(it as MutableList<User>)
//                headerAdapter.updateFlowerCount(it.size)
//            }
//        })
//
//        val fab: View = findViewById(R.id.fab)
//        fab.setOnClickListener {
//            fabOnClick()
//        }
    }

    /* Opens FlowerDetailActivity when RecyclerView item is clicked. */
//    private fun adapterOnClick(flower: Flower) {
//        val intent = Intent(this, FlowerDetailActivity()::class.java)
//        intent.putExtra(FLOWER_ID, flower.id)
//        startActivity(intent)
//    }

    /* Adds flower to flowerList when FAB is clicked. */
//    private fun fabOnClick() {
//        val intent = Intent(this, AddFlowerActivity::class.java)
//        startActivityForResult(intent, newFlowerActivityRequestCode)
//    }
//
//    override fun onActivityResult(requestCode: Int, resultCode: Int, intentData: Intent?) {
//        super.onActivityResult(requestCode, resultCode, intentData)
//
//        /* Inserts flower into viewModel. */
//        if (requestCode == newFlowerActivityRequestCode && resultCode == Activity.RESULT_OK) {
//            intentData?.let { data ->
//                val flowerName = data.getStringExtra(USERNAME)
//                val flowerDescription = data.getStringExtra(SCORE)
//
//               // flowersListViewModel.insertFlower(flowerName, flowerDescription)
//            }
//        }
//    }
}