package br.edu.unisep.news_prg_dsm.ui.football

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.edu.unisep.news_prg_dsm.domain.dto.football.MatchDto
import br.edu.unisep.news_prg_dsm.domain.repository.FootballRepository
import br.edu.unisep.timesbooks.utils.FOOTBALL_BSA
import br.edu.unisep.timesbooks.utils.FOOTBALL_CLI
import kotlinx.coroutines.launch

class MatchHomeViewModel(private val repository: FootballRepository) : ViewModel() {

    var competition:String = FOOTBALL_BSA

    private val mMatches: MutableLiveData<List<MatchDto>> = MutableLiveData()
    val matches : LiveData<List<MatchDto>>
    get() = mMatches




    fun getMatches(competition:String) {
        viewModelScope.launch {
                val result = repository.getListMatch(competition)
                mMatches.postValue(result)
            }
        }
    }
