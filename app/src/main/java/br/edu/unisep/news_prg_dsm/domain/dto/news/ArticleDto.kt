package br.edu.unisep.news_prg_dsm.domain.dto.news

import java.time.LocalDate
import java.time.LocalTime


data class ArticleDto(

    val author: String?,
    val title: String?,
    val description: String?,
    val url: String?,
    val image: String?,
    val date: LocalDate?

)