package com.example.arcxpcodechallenge.data.framework.dto

import com.squareup.moshi.Json

data class PostContentDTO(
    @Json(name = "posts") val posts: List<PostDataDTO>
)
