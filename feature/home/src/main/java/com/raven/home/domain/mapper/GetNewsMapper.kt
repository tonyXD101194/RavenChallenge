package com.raven.home.domain.mapper

import com.raven.models.entity.NewEntity
import com.raven.models.model.MediaModel
import com.raven.models.model.MetadataModel
import com.raven.models.model.NewModel
import com.raven.models.response.NewsResponse
import javax.inject.Inject

class GetNewsMapper @Inject constructor() {

    fun transformDomainToUI(period: Int, params: NewsResponse): List<NewModel>  {

        val mutableListNew = mutableListOf<NewModel>()

        params.news.forEach { newResponse ->
            val mutableMedia = mutableListOf<MediaModel>()

            newResponse.media.forEach { mediaResponse ->
                val mutableMetadata = mutableListOf<MetadataModel>()

                mediaResponse.metadata.forEach { metadataResponse ->
                    mutableMetadata.add(
                        MetadataModel(
                            url = metadataResponse.url,
                            format = metadataResponse.format
                        )
                    )
                }

                mutableMedia.add(
                    MediaModel(
                        copyright = mediaResponse.copyright,
                        metadata = mutableMetadata
                    )
                )
            }
            mutableListNew.add(
                NewModel(
                    uri = newResponse.uri,
                    url = newResponse.url,
                    id = newResponse.id,
                    assetId = newResponse.assetId,
                    source = newResponse.source,
                    publishedDate = newResponse.publishedDate,
                    updatedTime = newResponse.updatedTime,
                    section = newResponse.section,
                    type = newResponse.type,
                    title = newResponse.title,
                    description = newResponse.description,
                    byline = newResponse.byline,
                    media = mutableMedia,
                    period = period
                )
            )
        }
        return mutableListNew
    }

    fun transformEntityToUI(params: List<NewEntity>?): List<NewModel>  {

        val mutableNewModel = mutableListOf<NewModel>()

        params?.let {
            it.forEach { newEntity ->

                val mutableMedia = mutableListOf<MediaModel>()
                val mutableMetadata = mutableListOf<MetadataModel>()

                mutableMetadata.add(
                    MetadataModel(
                        url = newEntity.url,
                        format = newEntity.format ?: ""
                    )
                )

                mutableMedia.add(
                    MediaModel(
                        copyright = newEntity.copyright ?: "",
                        metadata = mutableMetadata
                    )
                )

                mutableNewModel.add(
                    NewModel(
                        uri = newEntity.uri,
                        url = newEntity.url,
                        id = newEntity.id.toLong(),
                        assetId = newEntity.assetId,
                        source = newEntity.source,
                        publishedDate = newEntity.publishedDate,
                        updatedTime = newEntity.updatedTime,
                        section = "",
                        type = newEntity.type,
                        title = newEntity.title,
                        description = newEntity.description,
                        byline = newEntity.byline,
                        media = mutableMedia,
                        period = newEntity.period
                    )
                )
            }
        }

        return mutableNewModel
    }

    fun transformModelToDatabase(params: NewModel): NewEntity  {
        return NewEntity(
            id = params.id.toInt(),
            period = params.period,
            uri = params.uri,
            url = params.url,
            assetId = params.assetId,
            source = params.source,
            byline = params.byline,
            publishedDate = params.publishedDate,
            updatedTime = params.updatedTime,
            type = params.type,
            title = params.title,
            description = params.description,
            copyright = params.media.firstOrNull()?.copyright,
            urlImage = params.media.firstOrNull()?.metadata?.lastOrNull()?.url,
            format = params.media.firstOrNull()?.metadata?.lastOrNull()?.format
        )
    }

    fun transformDatabaseToModel(params: NewEntity?): NewModel?  {
        val model = params?.let {
            NewModel(
                id = params.id.toLong(),
                period = params.period,
                uri = params.uri,
                url = params.url,
                assetId = params.assetId,
                source = params.source,
                byline = params.byline,
                publishedDate = params.publishedDate,
                updatedTime = params.updatedTime,
                type = params.type,
                title = params.title,
                description = params.description,
                section = "",
                media = listOf(
                    MediaModel(
                        copyright = params.copyright!!,
                        metadata = listOf(
                            MetadataModel(
                                url = params.urlImage!!,
                                format = params.format!!
                            )
                        )
                    )
                )
            )
        }
        return model
    }
}
