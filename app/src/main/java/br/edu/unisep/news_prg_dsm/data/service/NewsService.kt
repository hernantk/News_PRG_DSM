package br.edu.unisep.news_prg_dsm.data.service

import br.edu.unisep.news_prg_dsm.data.remote.ArticleList
import br.edu.unisep.news_prg_dsm.data.remote.SourcesList
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {

    @GET(WS_GET_NEWS_EVERYTHING)
    suspend fun getNewsBySearch(
        @Query(PARAM_SEARCH) search: String,
        @Query(PARAM_SORT) sortBy: String = SORT_VALUE,
        @Query(PARAM_API_KEY) apiKey: String = API_KEY_VALUE
    ): ArticleList

    @GET(WS_GET_NEWS_TOP_HEADLINES)
    suspend fun getNewsTopHeadlines(
        @Query(PARAM_CATEGORY) category:String?,
        @Query(PARAM_COUNTRY) country:String = COUNTRY_VALUE,
        @Query(PARAM_PAGE_SIZE) pageSize : Int = PAGE_SIZE_VALUE,
        @Query(PARAM_API_KEY) apiKey: String = API_KEY_VALUE
    ): ArticleList

    @GET(WS_GET_SOURCES_BR)
    suspend fun getSources(
            @Query(PARAM_COUNTRY) country:String = COUNTRY_VALUE,
            @Query(PARAM_API_KEY) apiKey: String = API_KEY_VALUE
    ): SourcesList

}