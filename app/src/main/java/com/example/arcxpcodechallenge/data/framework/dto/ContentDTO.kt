package com.example.arcxpcodechallenge.data.framework.dto

import com.squareup.moshi.Json

data class ContentDTO(
    @Json(name = "posts") val posts: List<WashingtonPostDataDTO>
)
