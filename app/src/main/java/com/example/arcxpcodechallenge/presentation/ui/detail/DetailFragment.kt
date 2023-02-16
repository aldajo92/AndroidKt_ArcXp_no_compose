package com.example.arcxpcodechallenge.presentation.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.HtmlCompat
import androidx.fragment.app.Fragment
import com.example.arcxpcodechallenge.databinding.FragmentDetailBinding
import com.example.arcxpcodechallenge.presentation.models.PostUIModel

class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private var post: PostUIModel? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentDetailBinding.inflate(inflater, container, false)
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
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
