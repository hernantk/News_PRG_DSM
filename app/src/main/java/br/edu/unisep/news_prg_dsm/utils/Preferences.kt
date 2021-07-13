package br.edu.unisep.news_prg_dsm.utils

import android.content.Context
import android.content.SharedPreferences

object Preferences {



    private lateinit var preferences: SharedPreferences

    fun initialize(context: Context){
        preferences = context.getSharedPreferences("football-preferences", Context.MODE_PRIVATE)
    }

    fun getRound():Int{ return preferences.getInt("round",12)}
    fun setRoundForward(){
        val pictureNumber = preferences.getInt("round",12) + 1
        preferences.edit().putInt("round",pictureNumber).apply() }
    fun setRoundBackward(){
        val pictureNumber = preferences.getInt("round",12) - 1
        preferences.edit().putInt("round",pictureNumber).apply() }
}