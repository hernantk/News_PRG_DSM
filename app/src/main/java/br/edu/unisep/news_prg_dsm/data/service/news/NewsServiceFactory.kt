package br.edu.unisep.news_prg_dsm.data.service.news

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object NewsServiceFactory {

    private val httpClient = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(URL_BASE_NEWS)
        .client(httpClient)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    fun getService() = retrofit.create(NewsService::class.java)

}