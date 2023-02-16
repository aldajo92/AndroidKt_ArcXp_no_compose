package com.example.arcxpcodechallenge.repositories

import com.example.arcxpcodechallenge.framework.RequestStateResult
import com.example.arcxpcodechallenge.framework.networking.WashingtonPostAPI
import com.example.arcxpcodechallenge.data.PostModel
import com.example.arcxpcodechallenge.utils.toWashingtonPostData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.net.UnknownHostException

class PostsRepositoryImpl(private val api: WashingtonPostAPI) : PostsRepository {

    private var postMap: Map<Int, PostModel>? = null

    override fun getPostsFlow(): Flow<RequestStateResult<List<PostModel>?>> = flow {
        emit(RequestStateResult.Loading)
        try {
            val testData = api.getSimulationTestData()
            val body = testData.body()
            val result = body?.posts?.map { it.toWashingtonPostData() }
            postMap = result?.associateBy { it.id }
            emit(RequestStateResult.Success(result))
        } catch (e: UnknownHostException) {
            emit(RequestStateResult.NoInternet)
        }
    }

    override fun getPostById(id: Int): PostModel? = postMap?.get(id)

}
