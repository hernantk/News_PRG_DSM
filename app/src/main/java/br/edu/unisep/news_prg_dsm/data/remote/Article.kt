package br.edu.unisep.news_prg_dsm.data.remote

import com.squareup.moshi.Json

data class Article (
    @field:Json(name = "author") val author: String,
    @field:Json(name = "title") val title: String,
    @field:Json(name = "title") val description: String,
    @field:Json(name = "url") val url: String,
    @field:Json(name = "urlToImage") val image: String
)
