package br.edu.unisep.news_prg_dsm.domain.dto


data class ArticleDto(
    val author: String?,
    val title: String,
    val description: String,
    val url: String,
    val image: String?
)