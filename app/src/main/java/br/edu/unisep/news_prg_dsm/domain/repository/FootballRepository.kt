package br.edu.unisep.news_prg_dsm.domain.repository

import br.edu.unisep.news_prg_dsm.data.remote.football.match.Match
import br.edu.unisep.news_prg_dsm.data.remote.football.match.MatchList
import br.edu.unisep.news_prg_dsm.data.service.football.FootballService
import br.edu.unisep.news_prg_dsm.domain.dto.football.MatchDto
import br.edu.unisep.timesbooks.utils.FOOTBALL_BSA
import br.edu.unisep.timesbooks.utils.FOOTBALL_CLI
import java.time.LocalDate
import java.time.LocalTime

class FootballRepository(private val service: FootballService) {
    private var mResponse :MatchList? = null
    private var response: List<Match>? = null

    suspend fun getListMatch(competition:String,round :Int): List<MatchDto> {

        if(mResponse==null){
            mResponse = service.getListMatch(competition)
        }
        if(competition==FOOTBALL_BSA){
            response = mResponse!!.matches.filter { match -> match.round == round }
        }
        else if (competition==FOOTBALL_CLI){
            TODO()
        }




        return response!!.map { match ->
            MatchDto(
                match.homeTeam,
                match.awayTeam,
                match.score,
                LocalDate.parse(match.dateAndTime.removeRange(10,20)),
                LocalTime.parse(match.dateAndTime.removeRange(19,20).removeRange(0,11)),
                match.status
            )
        }
    }

}