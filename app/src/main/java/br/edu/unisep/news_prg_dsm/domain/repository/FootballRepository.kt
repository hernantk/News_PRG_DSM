package br.edu.unisep.news_prg_dsm.domain.repository

import br.edu.unisep.news_prg_dsm.data.service.football.FootballService
import br.edu.unisep.news_prg_dsm.domain.dto.football.MatchDto

class FootballRepository(private val service: FootballService) {


    suspend fun getListMatch(): List<MatchDto> {
        val response = service.getListMatch()

        return response.matches.map { match ->
            MatchDto(
                match.homeTeam,
                match.awayTeam,
                match.score
            )
        }
    }
}