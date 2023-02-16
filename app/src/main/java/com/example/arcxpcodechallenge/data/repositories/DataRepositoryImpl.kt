package com.example.arcxpcodechallenge.data.repositories

import android.util.Log
import com.example.arcxpcodechallenge.data.framework.networking.RetrofitClient
import com.example.arcxpcodechallenge.data.framework.networking.WashingtonPostAPI
import com.example.arcxpcodechallenge.data.models.PostModel
import com.example.arcxpcodechallenge.utils.toWashingtonPostData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class DataRepositoryImpl(private val api: WashingtonPostAPI = RetrofitClient.api) : DataRepository {

    override fun getData(): Flow<List<PostModel>?> = flow {
        val washingtonPostData = api.getSimulationTestData()
        val body = washingtonPostData.body()
        Log.i("DataRepositoryImpl", "washingtonPostData: $body")
        emit(washingtonPostData.body()?.posts?.map { it.toWashingtonPostData() })
    }

}
