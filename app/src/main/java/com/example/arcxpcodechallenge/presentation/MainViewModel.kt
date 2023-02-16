package com.example.arcxpcodechallenge.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.arcxpcodechallenge.data.framework.RequestStateResult
import com.example.arcxpcodechallenge.data.models.PostModel
import com.example.arcxpcodechallenge.data.repositories.PostsRepository
import com.example.arcxpcodechallenge.data.repositories.PostsRepositoryImpl

class MainViewModel(
    private val dataRepository: PostsRepository = PostsRepositoryImpl()
) : ViewModel() {

    private val dataFlow = dataRepository.getPostsFlow()
    val dataLiveData: LiveData<RequestStateResult<List<PostModel>?>> = dataFlow.asLiveData()

}
