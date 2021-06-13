package br.edu.unisep.news_prg_dsm.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.edu.unisep.news_prg_dsm.domain.dto.ArticleDto
import br.edu.unisep.news_prg_dsm.domain.repository.Repository
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val respository = Repository()


    val newsResult: MutableLiveData<List<ArticleDto>> = MutableLiveData()

    fun getNews() {
        viewModelScope.launch {
            val result = respository.getNews()

            newsResult.postValue(result)
        }
    }

    fun getNewsBySearch(search:String) {
        viewModelScope.launch {
            val result = respository.getNewsBySearch(search)

            newsResult.postValue(result)
        }
    }

    fun getNewsByCategory(category:String) {
        viewModelScope.launch {
            val result = respository.getNewsByCategory(category)

            newsResult.postValue(result)
        }
    }

}