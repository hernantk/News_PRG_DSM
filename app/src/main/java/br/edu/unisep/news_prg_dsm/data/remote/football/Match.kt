package br.edu.unisep.news_prg_dsm.data.remote.football

import com.squareup.moshi.Json

data class Match(
    @field:Json(name = "homeTeam") val homeTeam: HomeTeam,
    @field:Json(name = "awayTeam") val awayTeam: AwayTeam,
    @field:Json(name = "score") val score: Score
)
