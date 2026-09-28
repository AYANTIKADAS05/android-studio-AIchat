package com.example.myprojectapplication

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

        val list = arrayListOf(

            FriendModel(
                name = "Riya Sen",
                mutual = "8 mutual friends",
                time = "2y",
                image = R.drawable.ic_profile_blank
            ),

            FriendModel(
                name = "Arindam Roy",
                mutual = "4 mutual friends",
                time = "1y",
                image = R.drawable.ic_profile_blank
            ),

            FriendModel(
                name = "Moumita Ghosh",
                mutual = "7 mutual friends",
                time = "3w",
                image = R.drawable.ic_profile_blank
            ),

            FriendModel(
                name = "Sayan Dutta",
                mutual = "5 mutual friends",
                time = "6m",
                image = R.drawable.ic_profile_blank
            ),

            FriendModel(
                name = "Ananya Paul",
                mutual = "9 mutual friends",
                time = "1y",
                image = R.drawable.ic_profile_blank
            ),

            FriendModel(
                name = "Rahul Das",
                mutual = "3 mutual friends",
                time = "4w",
                image = R.drawable.ic_profile_blank
            ),

            FriendModel(
                name = "Tania Roy",
                mutual = "6 mutual friends",
                time = "2y",
                image = R.drawable.ic_profile_blank
            ),

            FriendModel(
                name = "Neha Ghosh",
                mutual = "10 mutual friends",
                time = "5m",
                image = R.drawable.ic_profile_blank
            )
        )

        recyclerView.adapter = FriendAdapter(list)
    }
}