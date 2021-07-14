package br.edu.unisep.news_prg_dsm.utils

import android.content.Context
import android.content.SharedPreferences
import br.edu.unisep.timesbooks.utils.DEFAULT_ROUND

object Preferences {



    private lateinit var preferences: SharedPreferences

    fun initialize(context: Context){
        preferences = context.getSharedPreferences("football-preferences", Context.MODE_PRIVATE)
    }

    fun getRound(competition:String):Int{ return preferences.getInt("round-${competition}",DEFAULT_ROUND)}

    fun setRoundForward(competition:String){
        val roundNumber = preferences.getInt("round-${competition}",DEFAULT_ROUND) + 1
        preferences.edit().putInt("round-${competition}",roundNumber).apply() }



    fun setRoundBackward(competition:String){
        val roundNumber = preferences.getInt("round-${competition}",DEFAULT_ROUND) - 1
        preferences.edit().putInt("round-${competition}",roundNumber).apply() }
}