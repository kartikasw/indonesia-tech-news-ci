package com.example.indonesianews.di

import com.example.core.domain.usecase.NewsInteractor
import com.example.core.domain.usecase.NewsUseCase
import com.example.indonesianews.detail.DetailNewsViewModel
import com.example.indonesianews.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<NewsUseCase> { NewsInteractor(get()) }
}

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
    viewModel { DetailNewsViewModel(get()) }
}