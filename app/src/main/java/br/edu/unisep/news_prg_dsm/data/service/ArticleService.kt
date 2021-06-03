package br.edu.unisep.news_prg_dsm.data.service

import br.edu.unisep.news_prg_dsm.data.remote.ArticleList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ArticleService {


    @GET(WS_GET_LIST)
    suspend fun getList(
        @Path(PARAM_DATE) date:String,
        @Query(PARAM_API_KEY) apiKey: String = API_KEY_VALUE
    ): ArticleList

}