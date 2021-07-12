package br.edu.unisep.news_prg_dsm.data.remote.news

import com.squareup.moshi.Json

data class SourcesList (
    @field:Json(name = "sources") val sources: List<Sources>
    )