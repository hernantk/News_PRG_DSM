package br.edu.unisep.news_prg_dsm.data.remote.football

import com.squareup.moshi.Json

data class AwayTeam(
    @field:Json(name = "name") val name: String
)
