package com.example.arcxpcodechallenge.data.repositories

import com.example.arcxpcodechallenge.data.framework.dto.PostContentDTO
import com.example.arcxpcodechallenge.data.framework.dto.PostDataDTO
import com.example.arcxpcodechallenge.data.framework.networking.WashingtonPostAPI
import com.example.arcxpcodechallenge.data.models.PostModel
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.util.*
import kotlin.random.Random

@ExperimentalCoroutinesApi
@RunWith(JUnit4::class)
class PostsRepositoryImplTest {

    private val mockApi = mockk<WashingtonPostAPI>()
    private val postsRepositoryImpl = PostsRepositoryImpl(mockApi)

    @ExperimentalCoroutinesApi
    @Test
    fun `when getPosts() is called, then it should return a list of posts`() = runTest {
        val mockPost = PostContentDTO(List(10) { PostDataDTO(id = Random(10000L).nextInt()) })
        coEvery { mockApi.getSimulationTestData().body() } returns mockPost

        val resultList = mutableListOf<PostModel>()
        val flowData = postsRepositoryImpl.getPosts()
        flowData.collect {
            resultList.addAll(it!!)
        }
        assertEquals(10, resultList.size)
    }

}
