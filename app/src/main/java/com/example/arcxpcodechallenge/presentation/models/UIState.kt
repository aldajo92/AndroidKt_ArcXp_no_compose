package com.example.arcxpcodechallenge.presentation.models

sealed class UIState {
    object Loading : UIState()
    data class Success(val data: List<PostUIModel>) : UIState()
    data class Error(val error: String) : UIState()
}