package com.example.arcxpcodechallenge.utils

import com.example.arcxpcodechallenge.data.framework.dto.WashingtonPostDataDTO
import com.example.arcxpcodechallenge.data.models.PostModel
import org.junit.Assert.assertEquals
import org.junit.Test

class MapperUtilsTest{

    @Test
    fun `toWashingtonPostData() should return a PostModel`() {
        val washingtonPostDataDTO = WashingtonPostDataDTO(
            id = 1,
            title = "title",
            content = "content",
            date = "2021-03-01T00:00:00"
        )
        val expected = PostModel(
            id = 1,
            title = "title",
            content = "content",
            date = "2021-03-01T00:00:00"
        )
        val actual = washingtonPostDataDTO.toWashingtonPostData()
        assertEquals(expected, actual)
    }

}
