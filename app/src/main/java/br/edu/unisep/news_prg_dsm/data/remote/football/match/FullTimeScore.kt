package br.edu.unisep.news_prg_dsm.data.remote.football.match

import com.squareup.moshi.Json

data class FullTimeScore(
    @field:Json(name = "homeTeam") val homeTeamScore: Int?,
    @field:Json(name = "awayTeam") val awayTeamScore: Int?
)
