package com.example.arcxpcodechallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.squareup.moshi.Json
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

class MainActivity : AppCompatActivity() {

    val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.dataLiveData.observe(this) {
            when (it) {
                is List<WashingtonPostData> -> {
                    Log.i("MainActivity", "WashingtonPostData: $it")
                }
                else -> {} // handle null
            }
        }

        setContentView(R.layout.activity_main)
    }
}

class MainViewModel(
    private val dataRepository: DataRepository = DataRepositoryImpl()
) : ViewModel() {

    private val dataFlow = dataRepository.getData()
    val dataLiveData = dataFlow.asLiveData()

}

class DataRepositoryImpl(private val api: WashingtonPostAPI = RetrofitClient.api) : DataRepository {

    override fun getData(): Flow<List<WashingtonPostData>?> = flow {
        // TODO: Improve this later
        val washingtonPostData = api.washingtonGetData()
        emit(washingtonPostData.posts.map { it.toWashingtonPostData() })
//        if (washingtonPostData.isSuccessful) {
//        } else emit(null)
    }

//    override fun getData(): Flow<String> = flow {
//        val washingtonPostData = api.washingtonGetData()
//        emit(washingtonPostData)
//    }

}

interface DataRepository {
    fun getData(): Flow<List<WashingtonPostData>?>
//    fun getData(): Flow<String>
}

data class WashingtonPostData(
    val id: Int, val title: String, val content: String
)

object RetrofitClient {
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val api: WashingtonPostAPI by lazy {
        retrofit.create(WashingtonPostAPI::class.java)
    }
}

interface WashingtonPostAPI {

    @GET("simulation/simulation_test.json")
    fun washingtonGetData(): ContentDTO
}

data class ContentDTO(
    @Json(name = "posts") val posts: List<WashingtonPostDataDTO>
)

data class WashingtonPostDataDTO(
    @Json(name = "id") val id: Int,
    @Json(name = "title") val title: String,
    @Json(name = "content") val content: String,
    @Json(name = "date") val date: String,
)

// Mappers
fun WashingtonPostDataDTO.toWashingtonPostData(): WashingtonPostData {
    return WashingtonPostData(
        id = this.id, title = this.title, content = this.content
    )
}
