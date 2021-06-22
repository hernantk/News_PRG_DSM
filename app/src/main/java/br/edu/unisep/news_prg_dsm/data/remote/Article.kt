package br.edu.unisep.news_prg_dsm.data.remote

import androidx.annotation.Nullable
import com.squareup.moshi.Json

data class Article (
    @field:Json(name = "author") val author: String?,
    @field:Json(name = "title") val title: String?,
    @field:Json(name = "description") val description: String?,
    @field:Json(name = "url") val url: String?,
    @field:Json(name = "urlToImage") val image: String?,
    @field:Json(name = "publishedAt") val date: String?
)
