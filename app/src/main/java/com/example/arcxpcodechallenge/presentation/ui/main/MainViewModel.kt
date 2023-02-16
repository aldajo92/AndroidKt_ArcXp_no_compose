package com.example.arcxpcodechallenge.presentation.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.arcxpcodechallenge.framework.RequestStateResult
import com.example.arcxpcodechallenge.presentation.models.UIState
import com.example.arcxpcodechallenge.repositories.PostsRepository
import com.example.arcxpcodechallenge.utils.toUIModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val dataRepository: PostsRepository
) : ViewModel() {

    private val dataFlow = dataRepository.getPostsFlow().map {
        when (it) {
            is RequestStateResult.Loading -> UIState.Loading
            is RequestStateResult.Success -> {
                val processedData = it.data?.map { post -> post.toUIModel() } ?: emptyList()
                UIState.Success(processedData)
            }
            else -> UIState.Error("Error")
        }
    }

    val uiStatusLiveData: LiveData<UIState> = dataFlow.asLiveData()
    fun getPostById(id: Int) = dataRepository.getPostById(id)

}
