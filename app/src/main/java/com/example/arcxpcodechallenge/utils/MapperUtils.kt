package com.example.arcxpcodechallenge.utils

import com.example.arcxpcodechallenge.data.models.PostModel
import com.example.arcxpcodechallenge.data.framework.dto.PostDataDTO

fun PostDataDTO.toWashingtonPostData(): PostModel {
    return PostModel(
        id = this.id,
        title = this.title,
        content = this.content,
        date = this.date
    )
}
