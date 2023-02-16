package com.example.arcxpcodechallenge.data.repositories

import com.example.arcxpcodechallenge.data.models.PostModel
import kotlinx.coroutines.flow.Flow

interface PostsRepository {
    fun getPosts(): Flow<List<PostModel>?>
}
