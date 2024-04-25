package com.raven.home.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.raven.home.R
import com.raven.home.databinding.ArticleNetworkFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArticleNetworkFragment : Fragment() {

    private lateinit var binding: ArticleNetworkFragmentBinding
    private val navArgs: ArticleNetworkFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ArticleNetworkFragmentBinding.bind(
            inflater.inflate(R.layout.article_network_fragment, container, false)
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.initializeListeners()
        this.showArticle()
    }

    private fun initializeListeners() {
        requireActivity().onBackPressedDispatcher.addCallback {
            findNavController().popBackStack()
        }
    }

    private fun showArticle() {
        binding.wvArticle.loadUrl(navArgs.urlNew)
    }
}