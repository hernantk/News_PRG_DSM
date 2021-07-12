package br.edu.unisep.news_prg_dsm.data.service.football

import br.edu.unisep.news_prg_dsm.data.remote.football.MatchList
import br.edu.unisep.news_prg_dsm.data.service.API_KEY_VALUE_FOOTBALL
import br.edu.unisep.news_prg_dsm.data.service.PARAM_API_KEY_FOOTBALL
import br.edu.unisep.news_prg_dsm.data.service.PARAM_ID
import br.edu.unisep.news_prg_dsm.data.service.WS_GET_LIST_MATCH
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query
import java.time.LocalDate
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities

interface FootballService {

    @GET(WS_GET_LIST_MATCH)
    suspend fun getListMatch(
        @Path(PARAM_ID) id: String = "BSA",
        @Query("matchday") day: Int = LocalDate.now().dayOfMonth,
        @Header(PARAM_API_KEY_FOOTBALL) apiKey: String = API_KEY_VALUE_FOOTBALL
    ): MatchList

}