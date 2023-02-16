package com.example.arcxpcodechallenge.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.arcxpcodechallenge.data.models.PostModel
import com.example.arcxpcodechallenge.databinding.ActivityMainBinding
import com.example.arcxpcodechallenge.presentation.adapter.PostAdapter

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        val adapter = PostAdapter(lifecycleCoroutineScope = lifecycleScope)

        viewModel.dataLiveData.observe(this) {
            when (it) {
                is List<PostModel> -> {
                    adapter.updateData(it)
                    Log.i("MainActivity", "WashingtonPostData: $it")
                }
                else -> {} // handle null
            }
        }

        binding.rvPosts.adapter = adapter
        binding.rvPosts.layoutManager = LinearLayoutManager(this)

        setContentView(binding.root)
    }
}
