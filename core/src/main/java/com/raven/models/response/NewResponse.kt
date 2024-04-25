package com.raven.models.response

import com.google.gson.annotations.SerializedName

data class NewResponse (
    @SerializedName("uri")
    val uri: String,

    @SerializedName("url")
    val url: String,

    @SerializedName("id")
    val id: Long,

    @SerializedName("asset_id")
    val assetId: Long,

    @SerializedName("source")
    val source: String,

    @SerializedName("byline")
    val byline: String,

    @SerializedName("published_date")
    val publishedDate: String,

    @SerializedName("updated")
    val updatedTime: String,

    @SerializedName("section")
    val section: String,

    @SerializedName("type")
    val type: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("abstract")
    val description: String,

    @SerializedName("media")
    val media: List<MediaResponse>
)