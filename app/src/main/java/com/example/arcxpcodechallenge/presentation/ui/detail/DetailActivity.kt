package com.example.arcxpcodechallenge.presentation.ui.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.arcxpcodechallenge.databinding.ActivityDetailBinding
import com.example.arcxpcodechallenge.presentation.ui.main.MainViewModel

class DetailActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)

        val postId = intent.getIntExtra(POST_ID, 0)
        val post = viewModel.getPostById(postId)

        supportActionBar?.title = post?.title

        setContentView(binding.root)
    }

    companion object {
        const val POST_ID = "POST_ID"
        fun newIntent(context: Context, postId: Int) =
            Intent(context, DetailActivity::class.java).apply {
                putExtra(POST_ID, postId)
            }
    }

}
