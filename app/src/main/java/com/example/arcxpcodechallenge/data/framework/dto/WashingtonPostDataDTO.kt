package com.example.arcxpcodechallenge.data.framework.dto

import com.squareup.moshi.Json

data class WashingtonPostDataDTO(
    @Json(name = "id") val id: Int,
    @Json(name = "title") val title: String,
    @Json(name = "content") val content: String,
    @Json(name = "date") val date: String,
)
