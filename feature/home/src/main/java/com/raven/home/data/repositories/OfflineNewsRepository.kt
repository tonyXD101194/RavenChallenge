package com.raven.home.data.repositories

import com.raven.core.dao.NewsDao
import com.raven.models.entity.NewEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class OfflineNewsRepository @Inject constructor(
    private val newsDao: NewsDao
) : NewsRepository {

    override fun getAllNews(period: Int): Flow<List<NewEntity>?> {
        val flow: Flow<List<NewEntity>?> = flow {
            val response = newsDao.getNews(period)
            emit(response) // Emits the result of the request to the flow
        }

        return flow
    }

    override fun getNew(id: Int): Flow<NewEntity?> {
        val flow: Flow<NewEntity?> = flow {
            val response = newsDao.getNewById(id)
            emit(response) // Emits the result of the request to the flow
        }

        return flow
    }

    override suspend fun insertNew(newEntity: NewEntity) {
        newsDao.insert(newEntity)
    }

    override suspend fun deleteNews(period: Int) {
        newsDao.deleteNews(period)
    }
}