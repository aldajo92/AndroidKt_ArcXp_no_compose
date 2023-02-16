package com.example.arcxpcodechallenge.framework.dto

import com.squareup.moshi.Json

data class PostContentDTO(
    @Json(name = "posts") val posts: List<PostDataDTO>
)
