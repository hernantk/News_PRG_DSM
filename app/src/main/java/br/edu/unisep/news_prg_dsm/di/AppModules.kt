package br.edu.unisep.news_prg_dsm.di

import br.edu.unisep.news_prg_dsm.data.service.NewsService
import br.edu.unisep.news_prg_dsm.data.service.factory.NewsServiceFactory
import br.edu.unisep.news_prg_dsm.domain.repository.NewsRepository
import br.edu.unisep.news_prg_dsm.ui.home.HomeViewModel
import br.edu.unisep.news_prg_dsm.ui.home.adapter.HomeAdapter
import br.edu.unisep.news_prg_dsm.ui.sources.SourcesViewModel
import br.edu.unisep.news_prg_dsm.ui.sources.adapter.SourcesAdapter
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val serviceModule = module {
    single{NewsServiceFactory.getService()}
}

val repositoryModule = module {
    single {NewsRepository(get())}
}

val viewModelModule = module {
    viewModel{HomeViewModel(get())}
    viewModel{SourcesViewModel(get())}
}

val adapterModule = module {
    factory{HomeAdapter()}
    factory{SourcesAdapter()}
}

