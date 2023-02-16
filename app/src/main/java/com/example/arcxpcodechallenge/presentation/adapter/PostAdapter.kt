package com.example.arcxpcodechallenge.presentation.adapter

import android.os.Build
import android.text.Html
import android.text.Html.FROM_HTML_OPTION_USE_CSS_COLORS
import android.text.Html.ImageGetter
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.recyclerview.widget.RecyclerView
import com.example.arcxpcodechallenge.R
import com.example.arcxpcodechallenge.data.models.PostModel


class PostAdapter(
    private var listPostData: List<PostModel> = listOf(),
    private val lifecycleCoroutineScope: LifecycleCoroutineScope
) : RecyclerView.Adapter<PostViewHolder>() {

    fun updateData(newList: List<PostModel>) {
        listPostData = newList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return PostViewHolder(view, lifecycleCoroutineScope)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = listPostData[position]
        holder.bind(post)
    }

    override fun getItemCount(): Int = listPostData.size

}

fun TextView.setHTMLContent(content: String) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        this.text = Html.fromHtml(content, FROM_HTML_OPTION_USE_CSS_COLORS)
    } else {
        this.text = Html.fromHtml(content)
    }
}
