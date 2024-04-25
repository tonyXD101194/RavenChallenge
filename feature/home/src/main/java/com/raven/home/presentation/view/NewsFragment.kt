package com.raven.home.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.raven.home.R
import com.raven.home.databinding.NewsFragmentBinding
import com.raven.home.presentation.viewmodel.NewsViewModel
import com.raven.models.model.NewModel
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class NewsFragment : Fragment() {

    private lateinit var binding: NewsFragmentBinding
    private val viewModel: NewsViewModel by viewModels()
    private val navArgs: NewsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = NewsFragmentBinding.bind(
            inflater.inflate(R.layout.news_fragment, container, false)
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.initializeObservers()
        this.initializeListeners()

        viewModel.getNewModel(navArgs.newsId)
    }

    override fun onDestroy() {
        super.onDestroy()
        this.removeObservers()
    }

    private fun initializeObservers() {
        viewModel.article.observe(viewLifecycleOwner) {
            setView(it)
        }
    }

    private fun removeObservers() {
        viewModel.article.removeObservers(viewLifecycleOwner)
    }

    private fun initializeListeners() {
        binding.tvSeeMore.setOnClickListener {
            viewModel.article.value?.let {
                navToWebView(it.url)
            }
        }

        requireActivity().onBackPressedDispatcher.addCallback {
            findNavController().navigate(R.id.home_fragment)
        }
    }

    private fun setView(model: NewModel) {
        with(binding) {
            tvTitle.text = model.title
            tvSubtitle.text = model.description
            tvDescription.text = model.type
            tvDate.text = model.publishedDate
            tvAuthor.text = model.byline

            Picasso.with(requireContext()).load(model.media.firstOrNull()?.metadata?.firstOrNull()?.url).into(ivArticle)
        }
    }

    private fun navToWebView(url: String) = findNavController().navigate(
        NewsFragmentDirections.actionNewsFragmentToArticleFragment(url)
    )
}