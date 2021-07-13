package br.edu.unisep.news_prg_dsm.data.remote.football.match

import com.squareup.moshi.Json

data class MatchList(
    @field:Json(name = "matches") val matches: List<Match>
)
