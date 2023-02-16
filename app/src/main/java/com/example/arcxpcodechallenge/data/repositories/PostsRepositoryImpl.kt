package com.example.arcxpcodechallenge.data.repositories

import com.example.arcxpcodechallenge.framework.RequestStateResult
import com.example.arcxpcodechallenge.framework.networking.RetrofitClient
import com.example.arcxpcodechallenge.framework.networking.WashingtonPostAPI
import com.example.arcxpcodechallenge.data.models.PostModel
import com.example.arcxpcodechallenge.utils.toWashingtonPostData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PostsRepositoryImpl(private val api: WashingtonPostAPI = RetrofitClient.api) :
    PostsRepository {

    private var postMap: Map<Int, PostModel>? = null

    override fun getPostsFlow(): Flow<RequestStateResult<List<PostModel>?>> = flow {
        emit(RequestStateResult.Loading)
        val testData = api.getSimulationTestData()
        val body = testData.body()
        val result = body?.posts?.map { it.toWashingtonPostData() }
        postMap = result?.associateBy { it.id }
        emit(RequestStateResult.Success(result))
    }

    override fun getPostById(id: Int): PostModel? = postMap?.get(id)

}
