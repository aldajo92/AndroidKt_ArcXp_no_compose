package com.example.arcxpcodechallenge.presentation.ui.main

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.arcxpcodechallenge.R
import com.example.arcxpcodechallenge.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var connectionLiveData: ConnectionLiveData

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        connectionLiveData = ConnectionLiveData(this)
        connectionLiveData.observe(this) { isNetworkAvailable ->
            isNetworkAvailable?.let {
                binding.groupNoInternet.visibility = if (it) View.GONE else View.VISIBLE
            }
        }

        setContentView(binding.root)

        navController = findNavController(R.id.nav_host_fragment)
    }

}
