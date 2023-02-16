package com.example.arcxpcodechallenge.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.arcxpcodechallenge.data.repositories.PostsRepository
import com.example.arcxpcodechallenge.data.repositories.PostsRepositoryImpl

class MainViewModel(
  private val dataRepository: PostsRepository = PostsRepositoryImpl()
) : ViewModel() {

    private val dataFlow = dataRepository.getPosts()
    val dataLiveData = dataFlow.asLiveData()

}
