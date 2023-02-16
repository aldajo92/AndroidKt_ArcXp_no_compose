package com.example.arcxpcodechallenge.utils

import com.example.arcxpcodechallenge.framework.dto.PostDataDTO
import com.example.arcxpcodechallenge.data.models.PostModel
import org.junit.Assert.assertEquals
import org.junit.Test

class MapperUtilsTest{

    @Test
    fun `toWashingtonPostData() should return a PostModel`() {
        val postDataDTO = PostDataDTO(
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
        val actual = postDataDTO.toWashingtonPostData()
        assertEquals(expected, actual)
    }

}
