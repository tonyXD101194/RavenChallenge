package com.raven.home.di

import com.raven.core.dao.NewsDao
import com.raven.home.data.repositories.HomeRepository
import com.raven.home.data.remote.service.HomeService
import com.raven.home.data.repositories.OfflineNewsRepository
import com.raven.home.domain.HomeDataSource
import com.raven.home.domain.mapper.GetNewsMapper
import com.raven.home.domain.usecases.DeleteArticleUseCase
import com.raven.home.domain.usecases.GeArticleUseCase
import com.raven.home.domain.usecases.GeArticlesUseCase
import com.raven.home.domain.usecases.GeNewsUseCase
import com.raven.home.domain.usecases.SetArticleUseCase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
abstract class HomeModule {

    @Binds
    abstract fun bindHiringSource(repository: HomeRepository): HomeDataSource

    companion object {

        @Provides
        fun providesHomeService(retrofit: Retrofit): HomeService =
            retrofit.create(HomeService::class.java)

        @Provides
        fun providesHomeRepository(
            homeService: HomeService,
            offlineNewsRepository: OfflineNewsRepository): HomeRepository {
            return HomeRepository(homeService, offlineNewsRepository)
        }

        @Provides
        fun providesOfflineNewsRepository(newsDao: NewsDao): OfflineNewsRepository {
            return OfflineNewsRepository(newsDao)
        }

        @Provides
        fun providesGetNewsMapper() = GetNewsMapper()

        @Provides
        fun providesGeNewsUseCase(
            dataSource: HomeDataSource,
            mapper: GetNewsMapper,
        ): GeNewsUseCase = GeNewsUseCase(dataSource, mapper)

        @Provides
        fun providesGeArticlesUseCase(
            dataSource: HomeDataSource,
            mapper: GetNewsMapper
        ): GeArticlesUseCase = GeArticlesUseCase(dataSource, mapper)

        @Provides
        fun providesGeArticleUseCase(
            dataSource: HomeDataSource,
            mapper: GetNewsMapper
        ): GeArticleUseCase = GeArticleUseCase(dataSource, mapper)

        @Provides
        fun providesSetArticleUseCase(
            dataSource: HomeDataSource,
            mapper: GetNewsMapper
        ): SetArticleUseCase = SetArticleUseCase(dataSource, mapper)

        @Provides
        fun providesDeleteArticleUseCase(
            dataSource: HomeDataSource
        ): DeleteArticleUseCase = DeleteArticleUseCase(dataSource)

//        @Singleton
//        @Provides
//        fun providesDb(database: RoomDatabase): AppDatabase = database as AppDatabase
//
//        @Singleton
//        @Provides
//        fun providesNewsDao(database: AppDatabase): NewsDao = database.newsDao()
    }
}
