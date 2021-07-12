package br.edu.unisep.news_prg_dsm.data.service.news

import br.edu.unisep.news_prg_dsm.data.remote.news.ArticleList
import br.edu.unisep.news_prg_dsm.data.remote.news.SourcesList
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {

    @GET(WS_GET_NEWS_EVERYTHING)
    suspend fun getNewsBySearch(
        @Query(PARAM_SEARCH) search: String,
        @Query(PARAM_SORT) sortBy: String = SORT_VALUE,
        @Query(PARAM_API_KEY_NEWS) apiKey: String = API_KEY_VALUE_NEWS
    ): ArticleList

    @GET(WS_GET_NEWS_TOP_HEADLINES)
    suspend fun getNewsTopHeadlines(
        @Query(PARAM_CATEGORY) category:String?,
        @Query(PARAM_COUNTRY) country:String = COUNTRY_VALUE,
        @Query(PARAM_PAGE_SIZE) pageSize : Int = PAGE_SIZE_VALUE,
        @Query(PARAM_API_KEY_NEWS) apiKey: String = API_KEY_VALUE_NEWS
    ): ArticleList

    @GET(WS_GET_SOURCES)
    suspend fun getSources(
        @Query(PARAM_CATEGORY) category:String?,
        @Query(PARAM_API_KEY_NEWS) apiKey: String = API_KEY_VALUE_NEWS
    ): SourcesList

}