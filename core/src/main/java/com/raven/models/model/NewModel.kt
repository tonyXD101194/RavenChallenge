package com.raven.models.model


data class NewModel (
    val period: Int,
    val uri: String,
    val url: String,
    val id: Long,
    val assetId: Long,
    val source: String,
    val publishedDate: String,
    val updatedTime: String,
    val section: String,
    val byline: String,
    val type: String,
    val title: String,
    val description: String,
    val media: List<MediaModel>
)