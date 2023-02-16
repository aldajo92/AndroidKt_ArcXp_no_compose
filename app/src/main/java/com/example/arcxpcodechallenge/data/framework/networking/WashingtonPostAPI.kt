package com.example.arcxpcodechallenge.data.framework.networking

import com.example.arcxpcodechallenge.data.framework.dto.PostContentDTO
import retrofit2.Response
import retrofit2.http.GET

interface WashingtonPostAPI {

    @GET("wp-srv/simulation/simulation_test.json")
    suspend fun getSimulationTestData(): Response<PostContentDTO>

}
