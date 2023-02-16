package com.example.arcxpcodechallenge.presentation.adapter

import android.view.View
import android.widget.TextView
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.arcxpcodechallenge.R
import com.example.arcxpcodechallenge.data.models.PostModel
import com.example.arcxpcodechallenge.utils.applyDateFormat

class PostViewHolder(
    view: View,
) : RecyclerView.ViewHolder(view) {

    private val titleTextView = view.findViewById<TextView>(R.id.tvTitle)
//    private val contentTextView = view.findViewById<TextView>(R.id.tvBody)
    private val dateTextView = view.findViewById<TextView>(R.id.tvDate)

    fun bind(post: PostModel) {
        titleTextView.setHTMLContent(post.title)
//        contentTextView.text = HtmlCompat.fromHtml(
//            post.content,
//            HtmlCompat.FROM_HTML_SEPARATOR_LINE_BREAK_PARAGRAPH,
//            null,
//            null
//        )
        dateTextView.text = post.date.applyDateFormat(
            "yyyy-MM-dd HH:mm:ss",
            "MMM dd, yyyy"
        )
    }

}
