package com.raven.home.domain.usecases

import com.raven.core.bases.BaseUseCase
import com.raven.home.domain.HomeDataSource
import com.raven.home.domain.mapper.GetNewsMapper
import com.raven.models.model.NewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class GeArticleUseCase @Inject constructor(
    private val dataSource: HomeDataSource,
    private val mapper: GetNewsMapper,
): BaseUseCase<Int, NewModel?>() {

    override fun execute(params: Int): Flow<NewModel?> = runBlocking {
        dataSource.getNewDatabase(params).map {
            mapper.transformDatabaseToModel(it)
        }
    }
}