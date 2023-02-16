package com.example.arcxpcodechallenge.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.arcxpcodechallenge.R
import com.example.arcxpcodechallenge.databinding.FragmentHomeBinding
import com.example.arcxpcodechallenge.presentation.adapter.PostAdapter
import com.example.arcxpcodechallenge.presentation.models.UIState
import com.example.arcxpcodechallenge.presentation.ui.main.MainViewModel
import com.example.arcxpcodechallenge.utils.rotateFab
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val viewModel by viewModels<MainViewModel>()

    private var _binding: FragmentHomeBinding? = null

    private val postAdapter by lazy { PostAdapter() }
    private var toggleSort = false

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initLiveDataSubscriptions()
        initViews()
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.app_name)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initLiveDataSubscriptions() {
        viewModel.uiStatusLiveData.observe(viewLifecycleOwner) { uiStatus ->
            when (uiStatus) {
                is UIState.Loading -> showLoader(true)
                is UIState.Success -> {
                    showLoader(false)
                    showFabs(true)
                    uiStatus.data.let { postAdapter.updateData(it) }
                }
                is UIState.Error -> {
                    showLoader(false)
                    showFabs(false)
                }
            }
        }
    }

    private fun initViews() {
        binding.rvPosts.adapter = postAdapter
        binding.rvPosts.layoutManager = LinearLayoutManager(_binding?.root?.context)

        postAdapter.setItemClickListener {
            val bundle = bundleOf("post" to it)
            findNavController().navigate(R.id.action_HomeFragment_to_DetailFragment, bundle)
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