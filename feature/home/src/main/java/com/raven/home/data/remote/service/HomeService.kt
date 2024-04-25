package com.raven.home.data.remote.service

import com.raven.models.response.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface HomeService {

    @GET("emailed/{period}.json")
    suspend fun getNews(
        @Path(value = "period") period: Int,
    ): NewsResponse
}
