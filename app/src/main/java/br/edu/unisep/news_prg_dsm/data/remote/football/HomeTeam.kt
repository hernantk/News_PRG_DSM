package br.edu.unisep.news_prg_dsm.data.remote.football

import com.squareup.moshi.Json

data class HomeTeam(
    @field:Json(name = "name") val name: String
)


