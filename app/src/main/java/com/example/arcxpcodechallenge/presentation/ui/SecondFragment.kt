package com.example.arcxpcodechallenge.presentation.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.HtmlCompat
import androidx.navigation.fragment.findNavController
import com.example.arcxpcodechallenge.R
import com.example.arcxpcodechallenge.databinding.FragmentSecondBinding
import com.example.arcxpcodechallenge.presentation.models.PostUIModel

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private var post: PostUIModel? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        post = arguments?.get("post") as PostUIModel

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as AppCompatActivity).supportActionBar?.title = post?.date
        binding.tvTitle.text = post?.title?.uppercase()

        binding.tvBody.text = HtmlCompat.fromHtml(
            post?.content.orEmpty(),
            HtmlCompat.FROM_HTML_SEPARATOR_LINE_BREAK_PARAGRAPH,
            null,
            null
        )

//        binding.buttonSecond.setOnClickListener {
//            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
//        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}