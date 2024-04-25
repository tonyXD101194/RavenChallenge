package com.raven.home.domain.usecases

import com.raven.core.bases.BaseUseCase
import com.raven.home.domain.HomeDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class DeleteArticleUseCase @Inject constructor(
    private val dataSource: HomeDataSource,
) : BaseUseCase<Int, Unit>()  {

    override fun execute(params: Int): Flow<Unit> = runBlocking {
        dataSource.deleteNewDatabase(params)
        emptyFlow()
    }
}