package com.example.arcxpcodechallenge.presentation.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.arcxpcodechallenge.framework.RequestStateResult
import com.example.arcxpcodechallenge.presentation.models.UIState
import com.example.arcxpcodechallenge.repositories.PostsRepository
import com.example.arcxpcodechallenge.utils.toUIModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val dataRepository: PostsRepository
) : ViewModel() {

//    private val dataFlow = dataRepository.getPostsFlow().map {
//        when (it) {
//            is RequestStateResult.Loading -> UIState.Loading
//            is RequestStateResult.Success -> {
//                val processedData = it.data?.map { post -> post.toUIModel() } ?: emptyList()
//                UIState.Success(processedData)
//            }
//            else -> UIState.Error("Error")
//        }
//    }

    private val _uiStateLiveData: MutableLiveData<UIState> = MutableLiveData()
    val uiStatusLiveData: LiveData<UIState> = _uiStateLiveData
//    val uiStatusLiveData: LiveData<UIState> = dataFlow.asLiveData()

    fun getPosts() {
        viewModelScope.launch {
            dataRepository.getPostsFlow().collect {
                _uiStateLiveData.value = when (it) {
                    is RequestStateResult.Loading -> UIState.Loading
                    is RequestStateResult.Success -> {
                        val processedData = it.data?.map { post -> post.toUIModel() } ?: emptyList()
                        UIState.Success(processedData)
                    }
                    else -> UIState.Error("Error")
                }
            }
        }
    }

    fun getPostById(id: Int) = dataRepository.getPostById(id)

}
