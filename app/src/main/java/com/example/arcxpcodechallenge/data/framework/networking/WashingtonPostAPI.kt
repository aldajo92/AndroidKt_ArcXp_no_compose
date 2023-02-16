package com.example.arcxpcodechallenge.data.framework.networking

import com.example.arcxpcodechallenge.data.framework.dto.ContentDTO
import retrofit2.Response
import retrofit2.http.GET

interface WashingtonPostAPI {

    @GET("simulation/simulation_test.json")
    fun washingtonGetData(): Response<ContentDTO>

}
