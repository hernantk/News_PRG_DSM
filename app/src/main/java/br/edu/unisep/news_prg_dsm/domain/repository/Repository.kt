package br.edu.unisep.news_prg_dsm.domain.repository

import br.edu.unisep.news_prg_dsm.data.remote.Article
import br.edu.unisep.news_prg_dsm.data.remote.ArticleList
import br.edu.unisep.news_prg_dsm.data.service.factory.ArticleServiceFactory
import br.edu.unisep.news_prg_dsm.domain.dto.ArticleDto
import br.edu.unisep.news_prg_dsm.domain.dto.SourcesDto
import java.time.LocalDate

class Repository {

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
    suspend fun getNewsBySearch(search:String): List<ArticleDto> {

        val response = service.getNewsBySearch(search)

        return response.articles.map{ article ->
            ArticleDto(
                    article.author,
                    article.title,
                    article.description,
                    article.url,
                    article.image
            )}
    }
    suspend fun getSources(): List<SourcesDto> {

        val response = service.getSources()

        return response.sources.map{ sources ->
            SourcesDto(
                    sources.name,
                    sources.description,
                    sources.url
            )}
    }


}

