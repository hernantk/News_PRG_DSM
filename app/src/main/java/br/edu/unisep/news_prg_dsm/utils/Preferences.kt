package br.edu.unisep.news_prg_dsm.utils

import android.content.Context
import android.content.SharedPreferences
import br.edu.unisep.timesbooks.utils.*

object Preferences {

    private lateinit var preferences: SharedPreferences

    fun initialize(context: Context){
        preferences = context.getSharedPreferences("football-preferences", Context.MODE_PRIVATE)
    }

    fun getRound(competition:String):Int{
        return preferences.getInt("round-${competition}",DEFAULT_ROUND)}

    fun setRoundForward(competition:String){
        var roundNumber = preferences.getInt("round-${competition}",DEFAULT_ROUND) + 1

        if(competition== FOOTBALL_BSA && roundNumber== FOOTBALL_BSA_ROUNDs){
            roundNumber = FOOTBALL_BSA_ROUNDs
        }
        else if(competition== FOOTBALL_CLI && roundNumber== FOOTBALL_CLI_ROUNDs){
            roundNumber = FOOTBALL_CLI_ROUNDs}


        when(competition){
            FOOTBALL_BSA -> if(roundNumber> FOOTBALL_BSA_ROUNDs){roundNumber = FOOTBALL_BSA_ROUNDs}
            FOOTBALL_CLI -> if(roundNumber> FOOTBALL_CLI_ROUNDs){roundNumber = FOOTBALL_CLI_ROUNDs}
        }
        preferences.edit().putInt("round-${competition}",roundNumber).apply() }



    fun setRoundBackward(competition:String){
        var roundNumber = preferences.getInt("round-${competition}",DEFAULT_ROUND) - 1
        if(roundNumber<DEFAULT_ROUND){
            roundNumber = DEFAULT_ROUND
        }
        preferences.edit().putInt("round-${competition}",roundNumber).apply() }


}