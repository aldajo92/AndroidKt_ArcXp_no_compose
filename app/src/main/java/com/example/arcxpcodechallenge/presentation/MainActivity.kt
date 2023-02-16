package com.example.arcxpcodechallenge.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.arcxpcodechallenge.R
import com.example.arcxpcodechallenge.data.models.PostModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.dataLiveData.observe(this) {
            when (it) {
                is List<PostModel> -> {
                    Log.i("MainActivity", "WashingtonPostData: $it")
                }
                else -> {} // handle null
            }
        }

        setContentView(R.layout.activity_main)
    }
}

