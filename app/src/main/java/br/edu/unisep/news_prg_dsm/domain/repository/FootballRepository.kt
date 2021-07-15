package br.edu.unisep.news_prg_dsm.domain.repository

import br.edu.unisep.news_prg_dsm.data.service.football.FootballService
import br.edu.unisep.news_prg_dsm.domain.dto.football.MatchDto
import java.time.LocalDate
import java.time.LocalTime

class FootballRepository(private val service: FootballService) {

    suspend fun getListMatch(competition:String): List<MatchDto> {

        val response = service.getListMatch(competition)

        return response.matches.map { match ->
            MatchDto(
                match.homeTeam,
                match.awayTeam,
                match.score,
                LocalDate.parse(match.dateAndTime.removeRange(10,20)),
                LocalTime.parse(match.dateAndTime.removeRange(19,20).removeRange(0,11)),
                match.status,
                match.round
            )
        }
    }

}