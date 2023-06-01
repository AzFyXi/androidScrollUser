package com.example.androiduserscroll

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userList = listOf(
            User("Maria", "Vouli", R.drawable.profilone),
            User("George", "Lecompte", R.drawable.profiltwo),
            User("Julie", "Voudrou", R.drawable.profilthree),
            User("Marcus", "Navado", R.drawable.profilfour),
            User("Panda", "Stylé", R.drawable.profilfive),
            User("Maria", "Vouli", R.drawable.profilone),
            User("George", "Lecompte", R.drawable.profiltwo),
            User("Julie", "Voudrou", R.drawable.profilthree),
            User("Marcus", "Navado", R.drawable.profilfour),
            User("Panda", "Stylé", R.drawable.profilfive),
        )

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = UserAdapter(userList)
    }
}