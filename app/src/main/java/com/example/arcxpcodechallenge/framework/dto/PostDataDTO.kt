package com.example.arcxpcodechallenge.framework.dto

import com.squareup.moshi.Json

data class PostDataDTO(
    @Json(name = "id") val id: Int = 0,
    @Json(name = "title") val title: String = "",
    @Json(name = "content") val content: String = "",
    @Json(name = "date") val date: String = "",
)
