package br.edu.unisep.news_prg_dsm.domain.repository

import br.edu.unisep.news_prg_dsm.data.service.news.NewsService
import br.edu.unisep.news_prg_dsm.domain.dto.news.ArticleDto
import br.edu.unisep.news_prg_dsm.domain.dto.news.SourcesDto
import java.time.LocalDate

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
                    LocalDate.parse(article.date?.removeRange(10,20))
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
                LocalDate.parse(article.date?.removeRange(10,20))
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

