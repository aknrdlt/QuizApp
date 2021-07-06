package com.aknrdlt.quizapp.result.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.aknrdlt.quizapp.R
import com.aknrdlt.quizapp.data.User


class UserListAdapter : Adapter<UserListAdapter.UserListViewHolder>() {
    private val userList: MutableList<User> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListViewHolder {
        val view: View = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.user_result, parent, false)
        return UserListViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserListViewHolder, position: Int) {
        holder.bind(userList[position])
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun setItems(tweets: MutableList<User>) {
        userList.addAll(tweets)
        notifyDataSetChanged()
    }
    inner class UserListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.tv_username)
        private val nickTextView: TextView = itemView.findViewById(R.id.tv_score)
        fun bind(tweet: User) {
            nameTextView.text = tweet.name
            nickTextView.text = tweet.score.toString()
        }
    }
}