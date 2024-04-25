package com.raven.models.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "news")
data class NewEntity (
    @PrimaryKey
    @ColumnInfo
    val id: Int,

    @ColumnInfo
    val period: Int,

    @ColumnInfo
    val uri: String,

    @ColumnInfo
    val url: String,

    @ColumnInfo
    val assetId: Long,

    @ColumnInfo
    val source: String,

    @ColumnInfo
    val byline: String,

    @ColumnInfo
    val publishedDate: String,

    @ColumnInfo
    val updatedTime: String,

    @ColumnInfo
    val type: String,

    @ColumnInfo
    val title: String,

    @ColumnInfo
    val description: String,

    @ColumnInfo
    val copyright: String? = null,

    @ColumnInfo
    val urlImage: String? = null,

    @ColumnInfo
    val format: String? = null
)