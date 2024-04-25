package com.raven.home.data.repositories

import com.raven.home.data.remote.service.HomeService
import com.raven.home.domain.HomeDataSource
import com.raven.models.entity.NewEntity
import com.raven.models.response.NewsResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class HomeRepository @Inject constructor(
    private val homeService: HomeService,
    private val offlineNewsRepository: OfflineNewsRepository
) : HomeDataSource {

    override suspend fun getNews(period: Int): Flow<NewsResponse> {
        val flow: Flow<NewsResponse> = flow {
            val response = homeService.getNews(period)
            emit(response) // Emits the result of the request to the flow
        }

        return flow
    }

    override suspend fun getNewDatabase(id: Int): Flow<NewEntity?> {
        return offlineNewsRepository.getNew(id)
    }

    override suspend fun getNewsDatabase(period: Int): Flow<List<NewEntity>?> {
        return offlineNewsRepository.getAllNews(period)
    }

    override suspend fun setNewDatabase(article: NewEntity) {
        offlineNewsRepository.insertNew(article)
    }

    override suspend fun deleteNewDatabase(period: Int) {
        offlineNewsRepository.deleteNews(period)
    }
}
