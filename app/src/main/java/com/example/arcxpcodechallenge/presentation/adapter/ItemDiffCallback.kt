package com.example.arcxpcodechallenge.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.arcxpcodechallenge.presentation.models.PostUIModel

class ItemDiffCallback(
    private val oldList: List<PostUIModel>,
    private val newList: List<PostUIModel>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].content == newList[newItemPosition].content
    }
}
