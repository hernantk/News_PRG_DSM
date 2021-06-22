package br.edu.unisep.news_prg_dsm.app

import android.app.Application
import br.edu.unisep.news_prg_dsm.di.adapterModule
import br.edu.unisep.news_prg_dsm.di.repositoryModule
import br.edu.unisep.news_prg_dsm.di.serviceModule
import br.edu.unisep.news_prg_dsm.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class NewsApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidLogger()
            androidContext(applicationContext)
            modules(
                serviceModule,
                repositoryModule,
                adapterModule,
                viewModelModule
            )
        }
    }
}