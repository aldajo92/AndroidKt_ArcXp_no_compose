package com.example.arcxpcodechallenge.presentation.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.arcxpcodechallenge.framework.RequestStateResult
import com.example.arcxpcodechallenge.data.models.PostModel
import com.example.arcxpcodechallenge.data.repositories.PostsRepository
import com.example.arcxpcodechallenge.data.repositories.PostsRepositoryImpl

class MainViewModel(
    private val dataRepository: PostsRepository = PostsRepositoryImpl()
) : ViewModel() {

    private val dataFlow = dataRepository.getPostsFlow()
    val dataLiveData: LiveData<RequestStateResult<List<PostModel>?>> = dataFlow.asLiveData()

    fun getPostById(id: Int) = dataRepository.getPostById(id)

}
