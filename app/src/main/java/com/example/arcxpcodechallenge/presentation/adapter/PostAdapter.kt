package com.example.arcxpcodechallenge.presentation.adapter

import android.os.Build
import android.text.Html
import android.text.Html.FROM_HTML_OPTION_USE_CSS_COLORS
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.arcxpcodechallenge.R
import com.example.arcxpcodechallenge.presentation.models.PostUIModel
import com.example.arcxpcodechallenge.utils.sortByDate

class PostAdapter(
    private var listPostData: List<PostUIModel> = listOf(),
) : RecyclerView.Adapter<PostViewHolder>() {

    private var onItemClick: (PostUIModel) -> Unit = {}

    fun setItemClickListener(listener: (PostUIModel) -> Unit) {
        this.onItemClick = listener
    }

    fun updateData(newList: List<PostUIModel>) {
        val diffResult = DiffUtil.calculateDiff(ItemDiffCallback(listPostData, newList))
        diffResult.dispatchUpdatesTo(this)
        listPostData = newList
    }

    fun sortItemsByName(ascendant: Boolean) {
        val sortedList = if (ascendant) listPostData.sortedBy {
            it.title
        } else listPostData.sortedByDescending {
            it.title
        }
        val diffResult = DiffUtil.calculateDiff(ItemDiffCallback(listPostData, sortedList))
        diffResult.dispatchUpdatesTo(this)
        listPostData = sortedList
    }

    fun sortItemsByDate(ascendant: Boolean) {
        val sortedList = listPostData.sortByDate(ascendant)
        val diffResult = DiffUtil.calculateDiff(ItemDiffCallback(listPostData, sortedList))
        diffResult.dispatchUpdatesTo(this)
        listPostData = sortedList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = listPostData[position]
        holder.bind(post)
        holder.bindClick(onItemClick)
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
