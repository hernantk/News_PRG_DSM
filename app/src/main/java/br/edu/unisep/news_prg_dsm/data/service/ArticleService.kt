package br.edu.unisep.news_prg_dsm.data.service

import br.edu.unisep.news_prg_dsm.data.remote.ArticleList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ArticleService {


    @GET(WS_GET_LIST)
    suspend fun getNews(
            @Query(PARAM_SEARCH) search: String = SEARCH_VALUE,
            @Query(PARAM_FROM) date: String = DATE_VALUE,
            @Query(PARAM_SORT) sortBy: String = SORT_VALUE,
            @Query(PARAM_API_KEY) apiKey: String = API_KEY_VALUE
    ): ArticleList

}