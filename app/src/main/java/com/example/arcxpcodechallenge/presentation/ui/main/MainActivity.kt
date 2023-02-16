package com.example.arcxpcodechallenge.presentation.ui.main

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.arcxpcodechallenge.databinding.ActivityMainBinding
import com.example.arcxpcodechallenge.framework.onError
import com.example.arcxpcodechallenge.framework.onLoading
import com.example.arcxpcodechallenge.framework.onSuccess
import com.example.arcxpcodechallenge.presentation.adapter.PostAdapter
import com.example.arcxpcodechallenge.presentation.ui.detail.DetailActivity
import com.example.arcxpcodechallenge.utils.rotateFab

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    private val postAdapter by lazy { PostAdapter() }

    private var toggleSort = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        viewModel.dataLiveData.observe(this) { requestStateResult ->
            requestStateResult.onSuccess { listPostModel ->
                listPostModel?.let { postAdapter.updateData(it) }
                showLoader(false)
                showFabs(true)
            }.onLoading {
                showLoader(true)
                showFabs(false)
            }.onError {
                showLoader(false)
                showFabs(false)
            }
        }

        binding.rvPosts.adapter = postAdapter
        binding.rvPosts.layoutManager = LinearLayoutManager(this)

        postAdapter.setItemClickListener {
            val intent = DetailActivity.newIntent(this, it.id)
            startActivity(intent)
        }

        binding.fabSortByName.setOnClickListener {
            binding.fabSortByName.rotateFab()
            postAdapter.sortItemsByName(toggleSort)
            toggleSort = !toggleSort
        }

        binding.fabSortByDate.setOnClickListener {
            binding.fabSortByDate.rotateFab()
            postAdapter.sortItemsByDate(toggleSort)
            toggleSort = !toggleSort
        }

        setContentView(binding.root)
    }

    private fun showLoader(show: Boolean) {
        binding.progressBar.visibility = if (show) View.VISIBLE else View.GONE
        binding.loaderBackground.visibility = if (show) View.VISIBLE else View.GONE
    }

    private fun showFabs(show: Boolean) {
        binding.fabSortByName.visibility = if (show) View.VISIBLE else View.GONE
        binding.fabSortByDate.visibility = if (show) View.VISIBLE else View.GONE
    }

}
