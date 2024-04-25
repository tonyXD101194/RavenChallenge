package com.raven.models.response

import com.google.gson.annotations.SerializedName

data class MetadataResponse (
    @SerializedName("url")
    val url: String,

    @SerializedName("format")
    val format: String
)