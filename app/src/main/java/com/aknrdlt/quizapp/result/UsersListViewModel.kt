package com.aknrdlt.quizapp

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aknrdlt.quizapp.data.DataSource
import com.aknrdlt.quizapp.data.User
import kotlin.random.Random

class UsersListViewModel(val dataSource: DataSource) : ViewModel() {

    val usersLiveData = dataSource.getFlowerList()

    /* If the name and description are present, create new Flower and add it to the datasource */
    fun insertFlower(name: String?, score: Int?) {
        if (name == null || score == null) {
            return
        }

        val newFlower = User(
            Random.nextLong(),
            name,
            score
        )

        dataSource.addFlower(newFlower)
    }
}

class FlowersListViewModelFactory(private val context: Context) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UsersListViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return UsersListViewModel(
                dataSource = DataSource.getDataSource(context.resources)
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}