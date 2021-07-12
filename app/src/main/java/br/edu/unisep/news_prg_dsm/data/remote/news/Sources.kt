package br.edu.unisep.news_prg_dsm.data.remote.news

import androidx.annotation.Nullable
import com.squareup.moshi.Json

data class Sources (
    @field:Json(name = "name") val name: String,
    @field:Json(name = "description") val description: String,
    @field:Json(name = "url") val url: String
)
