package com.raven.models.response

import com.google.gson.annotations.SerializedName

data class NewsResponse (
    @SerializedName("status")
    val status: String,

    @SerializedName("copyright")
    val copyright: String,

    @SerializedName("num_results")
    val numResults: Int,

    @SerializedName("results")
    val news: List<NewResponse>
)