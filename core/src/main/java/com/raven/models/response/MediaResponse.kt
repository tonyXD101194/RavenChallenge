package com.raven.models.response

import com.google.gson.annotations.SerializedName

data class MediaResponse (

    @SerializedName("copyright")
    val copyright: String,

    @SerializedName("media-metadata")
    val metadata: List<MetadataResponse>,
)