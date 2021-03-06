package br.edu.unisep.news_prg_dsm.data.remote.news

import com.squareup.moshi.Json

data class ArticleList (
    @field:Json(name = "articles") val articles: MutableList<Article>
    )