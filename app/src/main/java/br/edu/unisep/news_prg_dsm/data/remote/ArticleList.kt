package br.edu.unisep.news_prg_dsm.data.remote

import com.squareup.moshi.Json

data class ArticleList (
    @field:Json(name = "articles") val books: List<Article>
    )