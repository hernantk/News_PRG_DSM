package br.edu.unisep.news_prg_dsm.domain.dto.football

import br.edu.unisep.news_prg_dsm.data.remote.football.AwayTeam
import br.edu.unisep.news_prg_dsm.data.remote.football.HomeTeam
import br.edu.unisep.news_prg_dsm.data.remote.football.Score
import java.time.LocalDate
import java.time.LocalTime

data class MatchDto(
    val homeTeam: HomeTeam,
    val awayTeam: AwayTeam,
    val score: Score,
    val date: LocalDate,
    val time: LocalTime,
    val status: String,
)
