package com.raven.home.presentation.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.raven.home.databinding.ItemArticleBinding
import com.raven.models.model.NewModel
import com.squareup.picasso.Picasso

class ArticleViewHolder(
    private val binding: ItemArticleBinding,
    private val onNewClick:(Long) -> Unit
) : ViewHolder(binding.root) {

    fun bind(model: NewModel) {
        with(binding) {
            tvTitle.text = model.title
            tvWriter.text = model.byline
            tvDate.text = model.publishedDate

            val imageFound = model.media.firstOrNull()?.metadata?.lastOrNull()

            imageFound?.let { image ->
                Picasso.with(root.context)
                    .load(image.url)
                    .into(ivArticle)
            }

            root.setOnClickListener {
                onNewClick.invoke(model.id)
            }
        }
    }
}