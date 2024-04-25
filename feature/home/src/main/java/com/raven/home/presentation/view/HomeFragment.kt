package com.raven.home.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.raven.home.R
import com.raven.home.databinding.HomeFragmentBinding
import com.raven.home.presentation.adapter.ArticleAdapter
import com.raven.home.presentation.viewmodel.HomeViewModel
import com.raven.models.model.NewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModels()
    private lateinit var binding: HomeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = HomeFragmentBinding.bind(
            inflater.inflate(R.layout.home_fragment, container, false)
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.initializeObservers()
        this.initializeListeners()
    }

    override fun onDestroy() {
        super.onDestroy()
        this.removeObservers()
    }

    private fun initializeObservers() {
        viewModel.news.observe(viewLifecycleOwner) {
            if (it.isNotEmpty()) {
                this.initializeAdapter(it)
            } else {
                // TODO show empty state
            }
        }
    }

    private fun removeObservers() {
        viewModel.news.removeObservers(viewLifecycleOwner)
    }

    private fun initializeListeners() {
        binding.rgPeriods.setOnCheckedChangeListener { _, checkedId ->
            val period = when(checkedId) {
                R.id.rbOne -> 1
                R.id.rbSeven -> 7
                R.id.rbThirty -> 30
                else -> 1
            }

            viewModel.getNews(period)
        }
    }

    private fun initializeAdapter(list: List<NewModel>) {
        binding.rvMostPopular.adapter = ArticleAdapter(list) { id ->
            findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToNewsFragment(id)
            )
        }
    }
}
