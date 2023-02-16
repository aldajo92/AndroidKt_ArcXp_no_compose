package com.example.arcxpcodechallenge.presentation.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.arcxpcodechallenge.R
import com.example.arcxpcodechallenge.data.models.PostModel
import com.example.arcxpcodechallenge.utils.applyDateFormat

class PostViewHolder(
    private val view: View,
) : RecyclerView.ViewHolder(view) {

    private val titleTextView = view.findViewById<TextView>(R.id.tvTitle)

    // TODO: Move this to detail screen
    //    private val contentTextView = view.findViewById<TextView>(R.id.tvBody)
    private val dateTextView = view.findViewById<TextView>(R.id.tvDate)

    private var postModel: PostModel? = null

    fun bind(model: PostModel) {
        this.postModel = model
        titleTextView.setHTMLContent(model.title)
        // TODO: Move this to detail screen
//        contentTextView.text = HtmlCompat.fromHtml(
//            post.content,
//            HtmlCompat.FROM_HTML_SEPARATOR_LINE_BREAK_PARAGRAPH,
//            null,
//            null
//        )
        dateTextView.text = model.date.applyDateFormat(
            "yyyy-MM-dd HH:mm:ss",
            "MMM dd, yyyy"
        )
    }

    fun bindClick(onClick: (PostModel) -> Unit) {
        view.setOnClickListener {
            postModel?.let { onClick(it) }
        }
    }

}
