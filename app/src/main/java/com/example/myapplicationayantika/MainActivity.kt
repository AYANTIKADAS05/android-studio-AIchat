package com.example.myapplicationayantika

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)

        val list = arrayListOf(FriendModel("Riya Sen", "8 mutual friends", "2y", R.drawable.ic_profile_blank),
            FriendModel("Arindam Roy", "4 mutual friends", "1y", R.drawable.ic_profile_blank),
            FriendModel("Moumita Ghosh", "7 mutual friends", "3w", R.drawable.ic_profile_blank),
            FriendModel("Sayan Dutta", "5 mutual friends", "6m", R.drawable.ic_profile_blank),
            FriendModel("Ananya Paul", "9 mutual friends", "1y", R.drawable.ic_profile_blank),
            FriendModel("Rahul Das", "3 mutual friends", "4w", R.drawable.ic_profile_blank),
            FriendModel("Tania Roy", "6 mutual friends", "2y", R.drawable.ic_profile_blank),
            FriendModel("Neha Ghosh", "10 mutual friends", "5m", R.drawable.ic_profile_blank))
        recyclerView.adapter = +FriendAdapter(list)
    }
}
