package br.edu.unisep.news_prg_dsm.domain.repository

import br.edu.unisep.news_prg_dsm.data.service.NewsService
import br.edu.unisep.news_prg_dsm.data.service.factory.NewsServiceFactory
import br.edu.unisep.news_prg_dsm.domain.dto.ArticleDto
import br.edu.unisep.news_prg_dsm.domain.dto.SourcesDto

class NewsRepository(private val service:NewsService) {


    suspend fun getNewsTopHeadlines(): List<ArticleDto> {

        val response = service.getNewsTopHeadlines(null)

        return response.articles.map{ article ->
        ArticleDto(

                article.author,
                article.title,
                article.description,
                article.url,
                article.image,
                article.date
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
                    article.image,
                    article.date
            )}
    }
    suspend fun getNewsTopHeadlinesByCategory(category:String): List<ArticleDto> {

        val response = service.getNewsTopHeadlines(category)

        return response.articles.map{ article ->
            ArticleDto(
                article.author,
                article.title,
                article.description,
                article.url,
                article.image,
                article.date
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

