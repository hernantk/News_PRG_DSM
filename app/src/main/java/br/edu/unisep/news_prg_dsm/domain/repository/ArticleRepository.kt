package br.edu.unisep.news_prg_dsm.domain.repository

import br.edu.unisep.news_prg_dsm.data.service.factory.ArticleServiceFactory
import br.edu.unisep.news_prg_dsm.domain.dto.ArticleDto
import java.time.LocalDate

class ArticleRepository {

    private val service = ArticleServiceFactory.getService()

    suspend fun getNews(): List<ArticleDto> {

        val response = service.getNews()

        return response.articles.map{ article ->
        ArticleDto(
                article.author,
                article.title,
                article.description,
                article.url,
                article.image
        )}
    }

}

