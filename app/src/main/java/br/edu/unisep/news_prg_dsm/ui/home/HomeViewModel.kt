package br.edu.unisep.news_prg_dsm.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.edu.unisep.news_prg_dsm.domain.dto.ArticleDto
import br.edu.unisep.news_prg_dsm.domain.repository.NewsRepository
import kotlinx.coroutines.launch

class HomeViewModel(private val repository :NewsRepository) : ViewModel() {



    val newsResult: MutableLiveData<List<ArticleDto>> = MutableLiveData()

    fun getNews() {
        viewModelScope.launch {
            val result = repository.getNewsTopHeadlines()

            newsResult.postValue(result)
        }
    }

    fun getNewsBySearch(search:String) {
        viewModelScope.launch {
            val result = repository.getNewsBySearch(search)

            newsResult.postValue(result)
        }
    }

    fun getNewsByCategory(category:String) {
        viewModelScope.launch {
            val result = repository.getNewsTopHeadlinesByCategory(category)

            newsResult.postValue(result)
        }
    }

}