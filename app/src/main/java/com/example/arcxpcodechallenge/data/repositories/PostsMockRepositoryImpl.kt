package com.example.arcxpcodechallenge.data.repositories

import com.example.arcxpcodechallenge.framework.RequestStateResult
import com.example.arcxpcodechallenge.utils.getObjectFromResourcesPath
import com.example.arcxpcodechallenge.framework.dto.PostContentDTO
import com.example.arcxpcodechallenge.data.models.PostModel
import com.example.arcxpcodechallenge.utils.toWashingtonPostData
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow

class PostsMockRepositoryImpl : PostsRepository {

    private val postStateFlow = MutableStateFlow<RequestStateResult<List<PostModel>?>>(
        RequestStateResult.Loading)

    private val mockJsonResponse: PostContentDTO by lazy {
        getObjectFromResourcesPath("mock_data.json", PostContentDTO::class.java)
    }

    private val postMap: Map<Int, PostModel> by lazy {
        mockJsonResponse.posts.map { it.toWashingtonPostData() }.associateBy { it.id }
    }

    override fun getPostsFlow(): Flow<RequestStateResult<List<PostModel>?>> = flow {
        delay(2000)
        val mappedObjects = mockJsonResponse.posts.map { it.toWashingtonPostData() }
        postStateFlow.value = RequestStateResult.Success(mappedObjects)
    }

    override fun getPostById(id: Int): PostModel? = postMap[id]

}
