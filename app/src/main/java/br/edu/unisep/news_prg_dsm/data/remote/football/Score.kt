package br.edu.unisep.news_prg_dsm.data.remote.football

import com.squareup.moshi.Json

data class Score(
    @field:Json(name = "fullTime") val fullTimeScore: FullTimeScore
)
