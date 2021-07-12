package br.edu.unisep.news_prg_dsm.domain.repository

import br.edu.unisep.news_prg_dsm.data.service.news.NewsService
import br.edu.unisep.news_prg_dsm.domain.dto.news.ArticleDto
import br.edu.unisep.news_prg_dsm.domain.dto.news.SourcesDto

class NewsRepository(private val service: NewsService) {


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
            )
        }
    }
    suspend fun getNewsTopHeadlines(category:String?): List<ArticleDto> {

        val response = service.getNewsTopHeadlines(category)

        return response.articles.map{ article ->
            ArticleDto(
                article.author,
                article.title,
                article.description,
                article.url,
                article.image,
                article.date
            )
        }
    }
    suspend fun getSources(category:String?): List<SourcesDto> {

        val response = service.getSources(category)

        return response.sources.map{ sources ->
            SourcesDto(
                    sources.name,
                    sources.description,
                    sources.url
            )
        }
    }


}

