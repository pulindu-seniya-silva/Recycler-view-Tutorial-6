package com.example.myapplication

import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyDataVH(itemView: View, parent: ViewGroup): RecyclerView.ViewHolder(itemView) {

        val tvUsername: TextView = itemView.findViewById(R.id.tvUserName)
        val tvDirection: TextView = itemView.findViewById(R.id.tvDescription)
        val btnLikes: Button = itemView.findViewById(R.id.btnLike)
    }

