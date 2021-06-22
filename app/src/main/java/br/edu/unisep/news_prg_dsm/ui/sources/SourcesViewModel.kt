package br.edu.unisep.news_prg_dsm.ui.sources

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.edu.unisep.news_prg_dsm.domain.dto.SourcesDto
import br.edu.unisep.news_prg_dsm.domain.repository.NewsRepository
import kotlinx.coroutines.launch

class SourcesViewModel(private val repository :NewsRepository) : ViewModel() {


    val resultSources: MutableLiveData<List<SourcesDto>> = MutableLiveData()

    fun getSources() {
        viewModelScope.launch {
            val result = repository.getSources()

            resultSources.postValue(result)
        }
    }



}