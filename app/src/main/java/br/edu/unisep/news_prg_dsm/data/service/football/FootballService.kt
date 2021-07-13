package br.edu.unisep.news_prg_dsm.data.service.football

import br.edu.unisep.news_prg_dsm.data.remote.football.MatchList
import br.edu.unisep.news_prg_dsm.data.service.*
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface FootballService {

    @GET(WS_GET_LIST_MATCH)
    suspend fun getListMatch(
        @Path(PARAM_ID) id: String = "BSA",
        @Query(PARAM_MATCHDAY_FOOTBALL) round: Int,
        @Header(PARAM_API_KEY_FOOTBALL) apiKey: String = API_KEY_VALUE_FOOTBALL
    ): MatchList

}