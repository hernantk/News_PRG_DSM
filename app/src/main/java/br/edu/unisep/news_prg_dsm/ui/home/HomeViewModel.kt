package br.edu.unisep.news_prg_dsm.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.edu.unisep.news_prg_dsm.domain.dto.news.ArticleDto
import br.edu.unisep.news_prg_dsm.domain.repository.NewsRepository
import kotlinx.coroutines.launch

class HomeViewModel(private val repository :NewsRepository) : ViewModel() {



    private val mnewsResult: MutableLiveData<List<ArticleDto>> = MutableLiveData()
    val newsResult: LiveData<List<ArticleDto>>
    get() = mnewsResult

    fun getNews() {
        viewModelScope.launch {
            val result = repository.getNewsTopHeadlines(null)

            mnewsResult.postValue(result)
        }
    }

    fun getNewsBySearch(search:String) {
        viewModelScope.launch {
            val result = repository.getNewsBySearch(search)

            mnewsResult.postValue(result)
        }
    }

    fun getNewsByCategory(category:String) {
        viewModelScope.launch {
            val result = repository.getNewsTopHeadlines(category)

            mnewsResult.postValue(result)
        }
    }

}