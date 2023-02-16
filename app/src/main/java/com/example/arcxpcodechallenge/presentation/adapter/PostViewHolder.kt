package com.example.arcxpcodechallenge.presentation.adapter

import android.view.View
import android.widget.TextView
import androidx.core.text.HtmlCompat
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.arcxpcodechallenge.R
import com.example.arcxpcodechallenge.data.models.PostModel
import com.example.arcxpcodechallenge.utils.HtmlImageGetter

class PostViewHolder(
    private val view: View,
    private val lifecycleCoroutineScope: LifecycleCoroutineScope
) : RecyclerView.ViewHolder(view) {

    private val title = view.findViewById<TextView>(R.id.tvTitle)
    private val content = view.findViewById<TextView>(R.id.tvBody)

    private val imageGetter = HtmlImageGetter(lifecycleCoroutineScope, view.resources, Glide.with(view), content)

    fun bind(post: PostModel) {
        title.setHTMLContent(post.title)
        content.text = HtmlCompat.fromHtml(
            post.content,
            HtmlCompat.FROM_HTML_SEPARATOR_LINE_BREAK_PARAGRAPH,
            imageGetter,
            null
        )
    }

}