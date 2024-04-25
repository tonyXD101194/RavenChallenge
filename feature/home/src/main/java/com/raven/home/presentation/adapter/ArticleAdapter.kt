package com.raven.home.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.raven.home.databinding.ItemArticleBinding
import com.raven.home.presentation.adapter.viewholder.ArticleViewHolder
import com.raven.models.model.NewModel

class ArticleAdapter(
    private val list: List<NewModel>,
    private val onNewClick:(Long) -> Unit
) : Adapter<ArticleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        return ArticleViewHolder(
            binding = ItemArticleBinding.inflate(
               LayoutInflater.from(parent.context), parent, false
            ),
            onNewClick = onNewClick
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bind(list[position])
    }
}