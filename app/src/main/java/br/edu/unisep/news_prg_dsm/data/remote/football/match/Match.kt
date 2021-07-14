package br.edu.unisep.news_prg_dsm.data.remote.football.match

import com.squareup.moshi.Json

data class Match(
    @field:Json(name = "homeTeam") val homeTeam: HomeTeam,
    @field:Json(name = "awayTeam") val awayTeam: AwayTeam,
    @field:Json(name = "score") val score: Score,
    @field:Json(name = "utcDate") val dateAndTime: String,
    @field:Json(name = "status") val status: String,
    @field:Json(name = "matchday") val round: Int?,
)
