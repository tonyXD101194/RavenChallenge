package com.raven.home.domain.usecases

import com.raven.core.bases.BaseUseCase
import com.raven.home.domain.HomeDataSource
import com.raven.home.domain.mapper.GetNewsMapper
import com.raven.models.model.NewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class SetArticleUseCase @Inject constructor(
    private val dataSource: HomeDataSource,
    private val mapper: GetNewsMapper,
) : BaseUseCase<NewModel, Unit>()  {

    override fun execute(params: NewModel): Flow<Unit> = runBlocking {
        val entity = mapper.transformModelToDatabase(params)
        dataSource.setNewDatabase(entity)
        emptyFlow()
    }
}