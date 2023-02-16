package com.example.arcxpcodechallenge.utils

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

}
