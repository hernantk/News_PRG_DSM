package br.edu.unisep.news_prg_dsm.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.edu.unisep.news_prg_dsm.domain.dto.ArticleDto
import br.edu.unisep.news_prg_dsm.domain.repository.ArticleRepository
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val respository = ArticleRepository()


    val newsResult: MutableLiveData<List<ArticleDto>> = MutableLiveData()

    fun getNews() {
        viewModelScope.launch {
            val result = respository.getNews()
            newsResult.postValue(result)
        }
    }

}