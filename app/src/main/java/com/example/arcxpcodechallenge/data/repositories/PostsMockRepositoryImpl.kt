package com.example.arcxpcodechallenge.data.repositories

import com.example.arcxpcodechallenge.utils.getObjectFromResourcesPath
import com.example.arcxpcodechallenge.data.framework.dto.PostContentDTO
import com.example.arcxpcodechallenge.data.models.PostModel
import com.example.arcxpcodechallenge.utils.toWashingtonPostData
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PostsMockRepositoryImpl : PostsRepository {

    private val mockJsonResponse: PostContentDTO by lazy {
        getObjectFromResourcesPath("mock_data.json", PostContentDTO::class.java)
    }

    override fun getPosts(): Flow<List<PostModel>?> = flow {
        delay(2000)
        val mappedObjects = mockJsonResponse.posts.map { it.toWashingtonPostData() }
        emit(mappedObjects)
    }

}
