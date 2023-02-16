package com.example.arcxpcodechallenge.data.repositories

import com.example.arcxpcodechallenge.getObjectFromResourcesPath
import com.example.arcxpcodechallenge.data.framework.dto.ContentDTO
import com.example.arcxpcodechallenge.data.models.PostModel
import com.example.arcxpcodechallenge.utils.toWashingtonPostData
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class DataMockRepositoryImpl : DataRepository {

    private val mockJsonResponse: ContentDTO by lazy {
        getObjectFromResourcesPath("mock_data.json", ContentDTO::class.java)
    }

    override fun getData(): Flow<List<PostModel>?> = flow {
        delay(2000)
        val mappedObjects = mockJsonResponse.posts.map { it.toWashingtonPostData() }
        emit(mappedObjects)
    }
}
