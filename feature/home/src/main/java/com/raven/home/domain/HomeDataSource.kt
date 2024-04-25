package com.raven.home.domain

import com.raven.models.entity.NewEntity
import com.raven.models.response.NewsResponse
import kotlinx.coroutines.flow.Flow

interface HomeDataSource {

    suspend fun getNews(period: Int): Flow<NewsResponse>

    suspend fun getNewDatabase(id: Int): Flow<NewEntity?>

    suspend fun getNewsDatabase(period: Int): Flow<List<NewEntity>?>

    suspend fun setNewDatabase(article: NewEntity)

    suspend fun deleteNewDatabase(period: Int)
}
