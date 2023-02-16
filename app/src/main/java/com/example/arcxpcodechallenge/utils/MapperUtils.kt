package com.example.arcxpcodechallenge.utils

import com.example.arcxpcodechallenge.data.PostModel
import com.example.arcxpcodechallenge.framework.dto.PostDataDTO
import com.example.arcxpcodechallenge.presentation.models.PostUIModel
import java.text.SimpleDateFormat
import java.util.*

fun PostDataDTO.toWashingtonPostData(): PostModel {
    return PostModel(
        id = this.id,
        title = this.title,
        content = this.content,
        date = this.date
    )
}

fun PostModel.toUIModel(): PostUIModel {
    return PostUIModel(
        id = this.id,
        title = this.title,
        content = this.content,
        date = this.date.applyDateFormat(
            "yyyy-MM-dd HH:mm:ss",
            "MMM dd, yyyy"),
        rawDate = this.date
    )
}

fun List<PostUIModel>.sortByDate(ascendant: Boolean, dateFormat: String = "yyyy-MM-dd HH:mm:ss"): List<PostUIModel> {
    val formatter = SimpleDateFormat(dateFormat, Locale.getDefault())
    return if (ascendant) {
        this.sortedBy { formatter.parse(it.rawDate) }
    } else {
        this.sortedByDescending { formatter.parse(it.rawDate) }
    }
}
