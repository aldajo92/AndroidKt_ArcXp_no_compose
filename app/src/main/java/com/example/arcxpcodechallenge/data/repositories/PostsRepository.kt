package com.example.arcxpcodechallenge.data.repositories

import com.example.arcxpcodechallenge.framework.RequestStateResult
import com.example.arcxpcodechallenge.data.models.PostModel
import kotlinx.coroutines.flow.Flow

interface PostsRepository {

    fun getPostsFlow(): Flow<RequestStateResult<List<PostModel>?>>

    fun getPostById(id: Int): PostModel?

}
