package com.example.arcxpcodechallenge.utils

import com.example.arcxpcodechallenge.presentation.models.PostUIModel
import org.junit.Assert.assertEquals
import org.junit.Test

class DateUtilsTest {

    @Test
    fun `applyDateFormat() should return a formatted date`() {
        val date = "2021-03-01T00:00:00"
        val expected = "01 Mar 2021"
        val actual = date.applyDateFormat()
        assertEquals(expected, actual)
    }

    @Test
    fun `applyDateFormat() should return an empty string`() {
        val date = ""
        val expected = ""
        val actual = date.applyDateFormat()
        assertEquals(expected, actual)
    }

    @Test
    fun `applyDateFormat() should return an empty string when date is null`() {
        val date: String? = null
        val expected = ""
        val actual = date.applyDateFormat()
        assertEquals(expected, actual)
    }

    @Test
    fun `applyDateFormat() should return an empty string when date is invalid`() {
        val date = "2021-03-01T00:00"
        val expected = ""
        val actual = date.applyDateFormat("yyyy-MM-dd'T'HH:mm:ss", "dd MMM yyyy")
        assertEquals(expected, actual)
    }

    @Test
    fun `applyDateFormat() should return a formatted date when date is valid`() {
        val date = "2021-03-01T00:00:00"
        val expected = "01 Mar 2021"
        val actual = date.applyDateFormat("yyyy-MM-dd'T'HH:mm:ss", "dd MMM yyyy")
        assertEquals(expected, actual)
    }

    @Test
    fun `applyDateFormat() should return a formatted date when date is valid and pattern is different`() {
        val date = "2021-03-01T00:00:00"
        val expected = "01 Mar 2021"
        val actual = date.applyDateFormat("yyyy-MM-dd'T'HH:mm:ss", "dd MMM yyyy")
        assertEquals(expected, actual)
    }

    @Test
    fun `applyDateFormat() should return a formatted date when date is valid and pattern is different and locale is different`() {
        val date = "2021-03-01 00:00:00"
        val expected = "01 Mar 2021"
        val actual = date.applyDateFormat("yyyy-MM-dd HH:mm:ss", "dd MMM yyyy")
        assertEquals(expected, actual)
    }

    @Test
    fun `sortByDate() should return a list of PostUIModel sorted by date ascendant`() {
        val postUIModelList = listOf(
            PostUIModel(
                id = 1,
                title = "title",
                content = "content",
                date = "01 Mar 2021",
                rawDate = "2021-03-01T00:00:00"
            ),
            PostUIModel(
                id = 2,
                title = "title",
                content = "content",
                date = "02 Mar 2021",
                rawDate = "2021-03-02T00:00:00"
            ),
            PostUIModel(
                id = 3,
                title = "title",
                content = "content",
                date = "03 Mar 2021",
                rawDate = "2021-03-03T00:00:00"
            )
        )
        val expected = listOf(
            PostUIModel(
                id = 1,
                title = "title",
                content = "content",
                date = "01 Mar 2021",
                rawDate = "2021-03-01T00:00:00"
            ),
            PostUIModel(
                id = 2,
                title = "title",
                content = "content",
                date = "02 Mar 2021",
                rawDate = "2021-03-02T00:00:00"
            ),
            PostUIModel(
                id = 3,
                title = "title",
                content = "content",
                date = "03 Mar 2021",
                rawDate = "2021-03-03T00:00:00"
            )
        )
        val actual = postUIModelList.sortByDate(true, "yyyy-MM-dd'T'HH:mm:ss")
        assertEquals(expected, actual)
    }

    @Test
    fun `sortByDate() should return a list of PostUIModel sorted by date descendant`(){
        val postUIModelList = listOf(
            PostUIModel(
                id = 1,
                title = "title",
                content = "content",
                date = "01 Mar 2021",
                rawDate = "2021-03-01T00:00:00"
            ),
            PostUIModel(
                id = 2,
                title = "title",
                content = "content",
                date = "02 Mar 2021",
                rawDate = "2021-03-02T00:00:00"
            ),
            PostUIModel(
                id = 3,
                title = "title",
                content = "content",
                date = "03 Mar 2021",
                rawDate = "2021-03-03T00:00:00"
            )
        )
        val expected = listOf(
            PostUIModel(
                id = 3,
                title = "title",
                content = "content",
                date = "03 Mar 2021",
                rawDate = "2021-03-03T00:00:00"
            ),
            PostUIModel(
                id = 2,
                title = "title",
                content = "content",
                date = "02 Mar 2021",
                rawDate = "2021-03-02T00:00:00"
            ),
            PostUIModel(
                id = 1,
                title = "title",
                content = "content",
                date = "01 Mar 2021",
                rawDate = "2021-03-01T00:00:00"
            )
        )
        val actual = postUIModelList.sortByDate(false, "yyyy-MM-dd'T'HH:mm:ss")
        assertEquals(expected, actual)
    }


}
