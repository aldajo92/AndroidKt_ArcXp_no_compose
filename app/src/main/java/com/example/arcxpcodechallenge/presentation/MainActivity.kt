package com.example.arcxpcodechallenge.presentation

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.arcxpcodechallenge.data.framework.onError
import com.example.arcxpcodechallenge.data.framework.onLoading
import com.example.arcxpcodechallenge.data.framework.onSuccess
import com.example.arcxpcodechallenge.databinding.ActivityMainBinding
import com.example.arcxpcodechallenge.presentation.adapter.PostAdapter

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    private val postAdapter by lazy {
        PostAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        viewModel.dataLiveData.observe(this) { requestStateResult ->
            requestStateResult.onSuccess { listPostModel ->
                listPostModel?.let { postAdapter.updateData(it) }
                showLoader(false)
            }.onLoading {
                showLoader(true)
            }.onError {
                showLoader(false)
            }
        }

        binding.rvPosts.adapter = postAdapter
        binding.rvPosts.layoutManager = LinearLayoutManager(this)

        setContentView(binding.root)
    }

    private fun showLoader(show: Boolean) {
        binding.progressBar.visibility = if (show) View.VISIBLE else View.GONE
        binding.loaderBackground.visibility = if (show) View.VISIBLE else View.GONE
    }

}
