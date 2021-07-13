package br.edu.unisep.news_prg_dsm.data.remote.football.match

import com.squareup.moshi.Json

data class HomeTeam(
    @field:Json(name = "id") val id: Int,
    @field:Json(name = "name") val name: String
)


