package br.edu.unisep.news_prg_dsm.data.remote.football

import com.squareup.moshi.Json

data class FullTimeScore(
    @field:Json(name = "homeTeam") val homeTeamScore: Int?=0,
    @field:Json(name = "awayTeam") val awayTeamScore: Int?=0
)
