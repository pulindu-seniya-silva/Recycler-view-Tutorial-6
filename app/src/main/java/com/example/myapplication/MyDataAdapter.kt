package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.model.Post

class MyDataAdapter (private val data:List<Post>): RecyclerView.Adapter<MyDataVH>() {

    private val likedState = MutableList(data.size) { false }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyDataVH {
        val layoutInflater = LayoutInflater.from(parent.context)


        val view: View = layoutInflater.inflate(R.layout.list_item_layout, parent, false)
        return MyDataVH(view, parent)


    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MyDataVH, position: Int) {
        val singleData = data[position]
        val isLiked = likedState[position]

        // Show like count with or without 👍
        holder.tvUsername.text = singleData.userName
        holder.tvDirection.text = singleData.description
        holder.btnLikes.text = if (isLiked) "${singleData.likes + 1}👍" else "${singleData.likes}"

        // Click listener to toggle like
        holder.btnLikes.setOnClickListener {
            likedState[position] = !likedState[position] // Toggle the state

            val updatedLikes = if (likedState[position]) {
                singleData.likes + 1
            } else {
                singleData.likes
            }

            holder.btnLikes.text = if (likedState[position]) "$updatedLikes👍" else "${singleData.likes}"
        }
    }

}