package com.example.arcxpcodechallenge.presentation.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.arcxpcodechallenge.R
import com.example.arcxpcodechallenge.presentation.models.PostUIModel

class PostViewHolder(
    private val view: View,
) : RecyclerView.ViewHolder(view) {

    private val titleTextView = view.findViewById<TextView>(R.id.tvTitle)
    private val dateTextView = view.findViewById<TextView>(R.id.tvDate)

    private var postModel: PostUIModel? = null

    fun bind(model: PostUIModel) {
        this.postModel = model
        titleTextView.setHTMLContent(model.title)
        dateTextView.text = model.date
    }

    fun bindClick(onClick: (PostUIModel) -> Unit) {
        view.setOnClickListener {
            postModel?.let { onClick(it) }
        }
    }

}
