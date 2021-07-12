package br.edu.unisep.news_prg_dsm.ui.sources

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.edu.unisep.news_prg_dsm.domain.dto.news.SourcesDto
import br.edu.unisep.news_prg_dsm.domain.repository.NewsRepository
import kotlinx.coroutines.launch

class SourcesViewModel(private val repository :NewsRepository) : ViewModel() {


    private val mresultSources: MutableLiveData<List<SourcesDto>> = MutableLiveData()
    val resultSources: LiveData<List<SourcesDto>>
    get() = mresultSources


    fun getSources() {
        viewModelScope.launch {
            val result = repository.getSources(null)

            mresultSources.postValue(result)
        }
    }
    fun getSourcesCategory(category: String) {
        viewModelScope.launch {
            val result = repository.getSources(category)

            mresultSources.postValue(result)
        }
    }



}