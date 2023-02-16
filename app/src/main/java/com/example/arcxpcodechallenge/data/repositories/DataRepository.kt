package com.example.arcxpcodechallenge.data.repositories

import com.example.arcxpcodechallenge.data.models.PostModel
import kotlinx.coroutines.flow.Flow

interface DataRepository {
    fun getData(): Flow<List<PostModel>?>
}
