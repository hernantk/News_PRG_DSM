package br.edu.unisep.news_prg_dsm.data.remote.football.team

import com.squareup.moshi.Json

data class Team(
    @field: Json(name = "crestUrl") val url: String
)
