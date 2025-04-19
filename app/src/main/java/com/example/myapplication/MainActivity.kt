package com.example.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.model.Post

class MainActivity : AppCompatActivity() {

    private val postsList = mutableListOf<Post>()

   init {
       postsList.add(Post("Hannah Ice", "Anyone else here from New York?", 62))
       postsList.add(Post("Jane Smith", "Sunsets are so beautiful.", 37))
       postsList.add(Post("George Hill", "Anyone else here from New York?", 32))
       postsList.add(Post("Hannah Ice", "At the beach with friends.", 32))
       postsList.add(Post("Charlie Davis", "Sunsets are so beautiful.", 57))
       postsList.add(Post("Eddie Foster", "At the beach with friends.", 64))
       postsList.add(Post("Bob Brown", "This is my first post on Android Social Media app", 19))
       postsList.add(Post("John Doe", "Loving the new app update!", 90))
       postsList.add(Post("Fay Green", "Look at my new dog!", 63))
       postsList.add(Post("Diana Evans", "Anyone else here from New York?", 38))
   }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val rvList:RecyclerView = findViewById(R.id.rvList)
        //rvList.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        rvList.layoutManager = GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false)
        val adapter = MyDataAdapter(postsList)
        rvList.adapter = adapter
    }
}