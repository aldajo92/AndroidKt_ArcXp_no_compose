package com.example.arcxpcodechallenge.data.repositories

import com.example.arcxpcodechallenge.data.framework.RequestStateResult
import com.example.arcxpcodechallenge.data.framework.networking.RetrofitClient
import com.example.arcxpcodechallenge.data.framework.networking.WashingtonPostAPI
import com.example.arcxpcodechallenge.data.models.PostModel
import com.example.arcxpcodechallenge.utils.toWashingtonPostData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PostsRepositoryImpl(private val api: WashingtonPostAPI = RetrofitClient.api) :
    PostsRepository {

    override fun getPostsFlow(): Flow<RequestStateResult<List<PostModel>?>> = flow {
        emit(RequestStateResult.Loading)
        val testData = api.getSimulationTestData()
        val body = testData.body()
        val result = body?.posts?.map { it.toWashingtonPostData() }
        emit(RequestStateResult.Success(result))
    }

}
