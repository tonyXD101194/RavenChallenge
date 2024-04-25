package com.raven.home.data.repositories

import com.raven.models.entity.NewEntity
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    fun getAllNews(period: Int): Flow<List<NewEntity>?>

    fun getNew(id: Int): Flow<NewEntity?>

    suspend fun insertNew(newEntity: NewEntity)

    suspend fun deleteNews(period: Int)
}