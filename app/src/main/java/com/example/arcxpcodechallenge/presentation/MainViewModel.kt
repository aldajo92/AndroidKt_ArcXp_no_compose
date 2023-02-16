package com.example.arcxpcodechallenge.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.arcxpcodechallenge.data.repositories.DataRepository
import com.example.arcxpcodechallenge.data.repositories.DataMockRepositoryImpl

class MainViewModel(
//  private val dataRepository: DataRepository = DataRepositoryImpl()
    private val dataRepository: DataRepository = DataMockRepositoryImpl()
) : ViewModel() {

    private val dataFlow = dataRepository.getData()
    val dataLiveData = dataFlow.asLiveData()

}
